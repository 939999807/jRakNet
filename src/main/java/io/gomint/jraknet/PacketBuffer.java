package io.gomint.jraknet;

import io.gomint.jraknet.datastructures.TriadRange;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

/**
 * @author BlackyPaw
 * @version 1.0
 */
public class PacketBuffer {

	private byte[] buffer;
	private int    offset;
	private int    position;


	public PacketBuffer( int capacity ) {
		this( new byte[capacity], 0 );
	}

	public PacketBuffer( byte[] buffer, int offset ) {
		this.buffer = buffer;
		this.offset = offset;
		this.position = offset;
	}

	public byte[] getBuffer() {
		return this.buffer;
	}

	public int getBufferOffset() {
		return this.offset;
	}

	public int getPosition() {
		return this.position;
	}

	public int getRemaining() {
		return this.buffer.length - this.position;
	}

	public void resetPosition() {
		this.position = this.offset;
	}

	public void readBytes( byte[] v ) {
		this.ensureRemaining( v.length );
		System.arraycopy( this.buffer, this.position, v, 0, v.length );
		this.position += v.length;
	}

	private void ensureRemaining( int remaining ) {
		if ( this.position + remaining > this.buffer.length ) {
			throw new IllegalArgumentException( "Cannot read more bytes than are available" );
		}
	}

	public short readShort() {
		this.ensureRemaining( 2 );
		return (short) ( ( this.buffer[this.position++] & 0xFF ) << 8 | ( this.buffer[this.position++] & 0xFF ) );
	}

	public short readLShort() {
		this.ensureRemaining( 2 );
		return (short) ( ( this.buffer[this.position++] & 0xFF ) | ( this.buffer[this.position++] & 0xFF ) << 8 );
	}

	public float readFloat() {
		return Float.intBitsToFloat( this.readInt() );
	}

	public int readInt() {
		this.ensureRemaining( 4 );
		return ( ( this.buffer[this.position++] & 0xFF ) << 24 |
		         ( this.buffer[this.position++] & 0xFF ) << 16 |
		         ( this.buffer[this.position++] & 0xFF ) << 8 |
		         ( this.buffer[this.position++] & 0xFF ) );
	}

	public double readDouble() {
		return Double.longBitsToDouble( this.readLong() );
	}

	public long readLong() {
		this.ensureRemaining( 8 );
		return ( ( ( (long) this.buffer[this.position++] & 0xFF ) << 56 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 48 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 40 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 32 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 24 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 16 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 8 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) ) );
	}

	public String readString() {
		int length = this.readUShort();
		this.ensureRemaining( length );
		String value = new String( this.buffer, this.position, length );
		this.position += length;
		return value;
	}

	public int readUShort() {
		this.ensureRemaining( 2 );
		return ( ( this.buffer[this.position++] & 0xFF ) << 8 | ( this.buffer[this.position++] & 0xFF ) );
	}

	public void readOfflineMessageDataId() {
		this.ensureRemaining( RakNetConstraints.OFFLINE_MESSAGE_DATA_ID.length );
		this.position += RakNetConstraints.OFFLINE_MESSAGE_DATA_ID.length;
	}

	public InetSocketAddress readAddress() {
		byte ipVersion = this.readByte();
		if ( ipVersion == 4 ) {
			this.ensureRemaining( 6 );

			long complement = ~this.readUInt();

			String hostname = String.valueOf( ( complement >> 24 ) & 0xFF ) + "." +
			                  String.valueOf( ( complement >> 16 ) & 0xFF ) + "." +
			                  String.valueOf( ( complement >> 8 ) & 0xFF ) + "." +
			                  String.valueOf( complement & 0xFF );
			int port = this.readUShort();

			return InetSocketAddress.createUnresolved( hostname, port );
		} else {
			// Currently IPv6 is not supported!
			this.skip( 24 );
			return null;
		}
	}

	public byte readByte() {
		this.ensureRemaining( 1 );
		return (byte) ( this.buffer[this.position++] & 0xFF );
	}

	public long readUInt() {
		this.ensureRemaining( 4 );
		return ( ( ( (long) this.buffer[this.position++] & 0xFF ) << 24 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 16 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) << 8 ) |
		         ( ( (long) this.buffer[this.position++] & 0xFF ) ) );
	}

	public UUID readUUID() {
		return new UUID( this.readLong(), this.readLong() );
	}

	public void skip( int length ) {
		this.ensureRemaining( length );
		this.position += length;
	}

	public TriadRange[] readTriadRangeList() {
		int          length = this.readUShort();
		boolean      isPair;
		TriadRange[] ranges = new TriadRange[length];
		int          min, max;
		for ( int i = 0; i < length; ++i ) {
			isPair = !this.readBoolean();
			min = this.readTriad();
			if ( isPair ) {
				max = this.readTriad();
				if ( min >= max ) {
					return null;
				}
			} else {
				max = min;
			}
			ranges[i] = new TriadRange( min, max );
		}
		return ranges;
	}

	public boolean readBoolean() {
		return ( this.readByte() != 0x00 );
	}

	public int readTriad() {
		this.ensureRemaining( 3 );
		return ( ( this.buffer[this.position++] & 0xFF ) |
				 ( this.buffer[this.position++] & 0xFF ) << 8 |
				 ( this.buffer[this.position++] & 0xFF ) << 16 );
	}

	public void writeBoolean( boolean v ) {
		this.writeByte( ( v ? (byte) 0x01 : (byte) 0x00 ) );
	}

	public void writeByte( byte v ) {
		this.ensureCapacity( 1 );
		this.buffer[this.position++] = v;
	}

	private void ensureCapacity( int capacity ) {
		while ( this.position + capacity > this.buffer.length ) {
			this.reallocate( capacity );
		}
	}

	private void reallocate( int extra ) {
		byte[] nextBuffer = new byte[2 * this.buffer.length];
		System.arraycopy( this.buffer, this.offset, nextBuffer, 0, this.buffer.length - this.offset );

		this.buffer = nextBuffer;
		this.position -= this.offset;
		this.offset = 0;
	}

	public void writeBytes( byte[] v ) {
		this.ensureCapacity( v.length );
		System.arraycopy( v, 0, this.buffer, this.position, v.length );
		this.position += v.length;
	}

	public void writeShort( short v ) {
		this.ensureCapacity( 2 );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
	}

	public void writeLShort( short v ) {
		this.ensureCapacity( 2 );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
	}

	public void writeUInt( long v ) {
		this.ensureCapacity( 4 );
		this.buffer[this.position++] = (byte) ( ( v >> 24 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 16 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
	}

	public void writeFloat( float v ) {
		this.writeInt( Float.floatToRawIntBits( v ) );
	}

	public void writeInt( int v ) {
		this.ensureCapacity( 4 );
		this.buffer[this.position++] = (byte) ( ( v >> 24 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 16 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
	}

	public void writeDouble( double v ) {
		this.writeLong( Double.doubleToRawLongBits( v ) );
	}

	public void writeLong( long v ) {
		this.ensureCapacity( 8 );
		this.buffer[this.position++] = (byte) ( ( v >> 56 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 48 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 40 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 32 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 24 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 16 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
	}

	public void writeString( String v ) {
		byte[] ascii = v.getBytes( StandardCharsets.UTF_8 );
		this.ensureCapacity( 2 + ascii.length );
		this.writeUShort( ascii.length );
		System.arraycopy( ascii, 0, this.buffer, this.position, ascii.length );
		this.position += ascii.length;
	}

	public void writeUShort( int v ) {
		this.ensureCapacity( 2 );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
	}

	public void writeOfflineMessageDataId() {
		this.ensureCapacity( RakNetConstraints.OFFLINE_MESSAGE_DATA_ID.length );
		System.arraycopy( RakNetConstraints.OFFLINE_MESSAGE_DATA_ID, 0, this.buffer, this.position, RakNetConstraints.OFFLINE_MESSAGE_DATA_ID.length );
		this.position += RakNetConstraints.OFFLINE_MESSAGE_DATA_ID.length;
	}

	public void writeAddress( SocketAddress address ) {
		if ( !( address instanceof InetSocketAddress ) ) {
			throw new IllegalArgumentException( "Unknown socket address family (only AF_INET and AF_INET6 supported)" );
		}

		InetSocketAddress addr = (InetSocketAddress) address;
		if ( addr.getAddress() instanceof Inet4Address ) {
			this.ensureCapacity( 7 );
			this.writeByte( (byte) 0x4 );

			Inet4Address inet  = (Inet4Address) addr.getAddress();
			byte[]       bytes = inet.getAddress();
			long complement = ( ( (long) bytes[0] << 24 ) |
			                    ( (long) bytes[1] << 16 ) |
			                    ( (long) bytes[2] << 8 ) |
			                    ( (long) bytes[3] ) );
			complement = ~complement;

			this.writeUInt( complement );
			this.writeUShort( addr.getPort() );
		} else {
			throw new IllegalArgumentException( "IPv6 is not yet supported" );
		}
	}

	public void writeUUID( UUID uuid ) {
		this.writeLong( uuid.getMostSignificantBits() );
		this.writeLong( uuid.getLeastSignificantBits() );
	}

	public void writeTriad( int v ) {
		this.ensureCapacity( 3 );
		this.buffer[this.position++] = (byte) ( v & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 8 ) & 0xFF );
		this.buffer[this.position++] = (byte) ( ( v >> 16 ) & 0xFF );
	}

	public int writeTriadRangeList( List<TriadRange> ranges, int offset, int length, int maxSize ) {
		this.ensureCapacity( 2 );

		// Reserve two bytes for the length:
		int mark = this.position;
		this.position += 2;
		maxSize -= 2;

		int count = 0;
		for ( int i = offset; i < offset + length; ++i ) {
			if ( ranges.get(i).getMin() == ranges.get(i).getMax() ) {
				if ( maxSize < 4 ) {
					break;
				}

				this.writeBoolean( true );
				this.writeTriad( ranges.get(i).getMin() );
				maxSize -= 4;
			} else {
				if ( maxSize < 7 ) {
					break;
				}

				this.writeBoolean( false );
				this.writeTriad( ranges.get(i).getMin() );
				this.writeTriad( ranges.get(i).getMax() );
				maxSize -= 7;
			}
			++count;
		}

		int pos = this.position;
		this.position = mark;
		this.writeUShort( count );
		this.position = pos;
		return count;
	}

	/**
	 * Set the pointer of this buffer to the specified position
	 *
	 * @param position The position at which the pointer should be
	 */
	public void setPosition( int position ) {
		this.position = position;
	}

}
