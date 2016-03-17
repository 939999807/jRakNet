package io.gomint.jraknet;

import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @author geNAZt
 * @version 1.0
 */
public class TestRunner {
    public static void main( String[] args ) {
        String hexThings = "84 02 00 00 00 00 48 00 00 00 00 00 00 0f 6d 9c \n" +
                "60 03 18 02 00 00 01 00 00 00 8e 8f 00 05 53 74 \n" +
                "65 76 65 00 00 00 2d 00 00 00 2d 0f 93 00 75 6d \n" +
                "11 b8 60 13 bb f9 29 4e 05 fb 01 f0 16 aa f0 19 \n" +
                "48 76 e5 00 13 31 39 32 2e 31 36 38 2e 31 2e 31 \n" +
                "31 38 3a 31 39 31 33 32 00 10 98 d3 db fc 1a de \n" +
                "18 3a 76 23 0b b9 9d ce b9 ce 00 0f 53 74 61 6e \n" +
                "64 61 72 64 5f 43 75 73 74 6f 6d 20 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 57 4c 47 \n" +
                "ff 45 3d 3b ff 30 2b 2b ff 1f 1b 1b ff 3d 32 30 \n" +
                "ff 30 2b 2b ff 45 3d 3b ff 57 4c 47 ff 30 2b 2b \n" +
                "ff 30 2b 2b ff 0a 09 0a ff 0a 09 0a ff 0a 09 0a \n" +
                "ff 0a 09 0a ff 30 2b 2b ff 30 2b 2b ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 57 4c 47 \n" +
                "ff 45 3d 3b ff 30 2b 2b ff 1f 1b 1b ff 54 49 45 \n" +
                "ff 30 2b 2b ff 45 3d 3b ff 57 4c 47 ff 85 6c 61 \n" +
                "ff 85 6c 61 ff 85 6c 61 ff 85 6c 61 ff 85 6c 61 \n" +
                "ff 85 6c 61 ff 85 6c 61 ff 85 6c 61 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 45 3d 3b \n" +
                "ff 45 3d 3b ff 30 2b 2b ff 1f 1b 1b ff 3d 32 30 \n" +
                "ff 30 2b 2b ff 45 3d 3b ff 45 3d 3b ff b0 93 78 \n" +
                "ff b0 93 78 ff 85 6c 61 ff 85 6c 61 ff 85 6c 61 \n" +
                "ff 85 6c 61 ff b0 93 78 ff b0 93 78 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 30 2b 2b \n" +
                "ff 30 2b 2b ff 0a 09 0a ff 1f 1b 1b ff 1f 1b 1b \n" +
                "ff 0a 09 0a ff 30 2b 2b ff 30 2b 2b ff c9 ae 81 \n" +
                "ff b0 93 78 ff 85 6c 61 ff 85 6c 61 ff 85 6c 61 \n" +
                "ff 85 6c 61 ff b0 93 78 ff c9 ae 81 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff a5 c7 cf \n" +
                "ff 88 ac bd ff 68 82 a3 ff 68 82 a3 ff 68 82 a3 \n" +
                "ff 68 82 a3 ff 88 ac bd ff a5 c7 cf ff b0 93 78 \n" +
                "ff b0 93 78 ff 85 6c 61 ff 85 6c 61 ff 85 6c 61 \n" +
                "ff 85 6c 61 ff b0 93 78 ff b0 93 78 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 4c 5f 80 \n" +
                "ff 4c 5f 80 ff 46 49 69 ff a6 51 51 ff bd 6a 53 \n" +
                "ff a6 51 51 ff 8a 46 4e ff 69 3c 47 ff 88 ac bd \n" +
                "ff 68 82 a3 ff 52 66 7d ff 52 66 7d ff 52 66 7d \n" +
                "ff 52 66 7d ff 68 82 a3 ff 88 ac bd ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 53 7c 96 \n" +
                "ff 53 7c 96 ff 4c 5f 80 ff e1 f0 ee ff f0 fa f6 \n" +
                "ff e1 f0 ee ff c8 e2 e3 ff c8 e2 e3 ff a5 c7 cf \n" +
                "ff 88 ac bd ff 88 ac bd ff 88 ac bd ff 88 ac bd \n" +
                "ff 88 ac bd ff 88 ac bd ff a5 c7 cf ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 88 ac bd ff 88 ac bd ff 88 ac bd \n" +
                "ff 88 ac bd ff 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 6a 9d ab \n" +
                "ff 53 7c 96 ff 4c 5f 80 ff a6 51 51 ff bd 6a 53 \n" +
                "ff bd 6a 53 ff a6 51 51 ff 8a 46 4e ff a5 c7 cf \n" +
                "ff a5 c7 cf ff 88 ac bd ff 88 ac bd ff 88 ac bd \n" +
                "ff 88 ac bd ff a5 c7 cf ff a5 c7 cf ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 a5 c7 cf ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff a5 c7 cf ff 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 57 4c 47 \n" +
                "ff 57 4c 47 ff 45 3d 3b ff 30 2b 2b ff a5 c7 cf \n" +
                "ff 4c 5f 80 ff 53 7c 96 ff 6a 9d ab ff 6a 9d ab \n" +
                "ff 53 7c 96 ff 4c 5f 80 ff e1 f0 ee ff f0 fa f6 \n" +
                "ff e1 f0 ee ff c8 e2 e3 ff c8 e2 e3 ff 8a 46 4e \n" +
                "ff c8 e2 e3 ff 69 3c 47 ff a5 c7 cf ff 30 2b 2b \n" +
                "ff 45 3d 3b ff 57 4c 47 ff 57 4c 47 ff 57 4c 47 \n" +
                "ff 45 3d 3b ff 30 2b 2b ff 3d 32 30 ff 1f 1b 1b \n" +
                "ff 30 2b 2b ff 45 3d 3b ff 57 4c 47 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 45 3d 3b \n" +
                "ff 45 3d 3b ff 45 3d 3b ff 30 2b 2b ff a5 c7 cf \n" +
                "ff 46 49 69 ff 4c 5f 80 ff 4c 5f 80 ff 4c 5f 80 \n" +
                "ff 4c 5f 80 ff 46 49 69 ff a6 51 51 ff bd 6a 53 \n" +
                "ff bd 6a 53 ff a6 51 51 ff 8a 46 4e ff 69 3c 47 \n" +
                "ff 8a 46 4e ff 69 3c 47 ff a5 c7 cf ff 30 2b 2b \n" +
                "ff 45 3d 3b ff 45 3d 3b ff 45 3d 3b ff 45 3d 3b \n" +
                "ff 45 3d 3b ff 30 2b 2b ff 5f 6e 7d ff 5f 6e 7d \n" +
                "ff 30 2b 2b ff 45 3d 3b ff 45 3d 3b ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 30 2b 2b \n" +
                "ff 30 2b 2b ff 30 2b 2b ff 0a 09 0a ff a5 c7 cf \n" +
                "ff c8 e2 e3 ff a5 c7 cf ff 88 ac bd ff 88 ac bd \n" +
                "ff 88 ac bd ff a5 c7 cf ff a5 c7 cf ff a5 c7 cf \n" +
                "ff a5 c7 cf ff 88 ac bd ff 88 ac bd ff 88 ac bd \n" +
                "ff a5 c7 cf ff c8 e2 e3 ff a5 c7 cf ff 0a 09 0a \n" +
                "ff 30 2b 2b ff 30 2b 2b ff 30 2b 2b ff 30 2b 2b \n" +
                "ff 0a 09 0a ff 5f 6e 7d ff 77 86 8f ff 77 86 8f \n" +
                "ff 5f 6e 7d ff 0a 09 0a ff 30 2b 2b ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 a5 c7 cf ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff e1 f0 ee ff c8 e2 e3 ff 00 00 00 00 00 00 00 \n" +
                "00 c8 e2 e3 ff e1 f0 ee ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff a5 c7 cf ff 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 77 86 8f ff 77 86 8f \n" +
                "ff 00 00 00 00 00 00 00 00 00 00 00 00 54 49 45 \n" +
                "ff 54 49 45 ff 3d 32 30 ff 1f 1b 1b ff a5 c7 cf \n" +
                "ff e1 f0 ee ff a6 51 51 ff 8a 46 4e ff 24 25 26 \n" +
                "ff 3b 3c 40 ff 24 25 26 ff 8a 46 4e ff a6 51 51 \n" +
                "ff 24 25 26 ff 3b 3c 40 ff 24 25 26 ff 8a 46 4e \n" +
                "ff a6 51 51 ff e1 f0 ee ff a5 c7 cf ff 1f 1b 1b \n" +
                "ff 3d 32 30 ff 54 49 45 ff 54 49 45 ff 54 49 45 \n" +
                "ff 3d 32 30 ff 77 86 8f ff a7 b6 b8 ff 92 a0 a6 \n" +
                "ff 77 86 8f ff 3d 32 30 ff 54 49 45 ff 00 00 00 \n" +
                "00 00 00 00 00 c9 ae 81 ff d6 c3 94 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 8a 46 4e ff bd 6a 53 \n" +
                "ff 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 d6 c3 94 \n" +
                "ff c9 ae 81 ff 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 a7 b6 b8 ff 92 a0 a6 \n" +
                "ff 00 00 00 00 00 00 00 00 00 00 00 00 1f 1b 1b \n" +
                "ff 1f 1b 1b ff 03 02 02 ff 03 02 02 ff 88 ac bd \n" +
                "ff c8 e2 e3 ff e1 f0 ee ff e1 f0 ee ff e1 f0 ee \n" +
                "ff e1 f0 ee ff c8 e2 e3 ff 69 3c 47 ff 8a 46 4e \n" +
                "ff c8 e2 e3 ff e1 f0 ee ff e1 f0 ee ff e1 f0 ee \n" +
                "ff e1 f0 ee ff c8 e2 e3 ff 88 ac bd ff 03 02 02 \n" +
                "ff 03 02 02 ff 1f 1b 1b ff 1f 1b 1b ff 1f 1b 1b \n" +
                "ff 03 02 02 ff 77 86 8f ff bb c7 c6 ff 92 a0 a6 \n" +
                "ff 77 86 8f ff 03 02 02 ff 1f 1b 1b ff 00 00 00 \n" +
                "00 00 00 00 00 b0 93 78 ff b0 93 78 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 69 3c 47 ff a6 51 51 \n" +
                "ff 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 b0 93 78 \n" +
                "ff b0 93 78 ff 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 bb c7 c6 ff 92 a0 a6 \n" +
                "ff 00 00 00 00 00 00 00 00 00 00 00 00 57 4c 47 \n" +
                "ff 45 3d 3b ff 45 3d 3b ff 30 2b 2b ff 88 ac bd \n" +
                "ff c8 e2 e3 ff c8 e2 e3 ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff 69 3c 47 ff a5 c7 cf ff 88 ac bd ff 88 ac bd \n" +
                "ff a5 c7 cf ff 69 3c 47 ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff c8 e2 e3 ff c8 e2 e3 ff 88 ac bd ff 30 2b 2b \n" +
                "ff 45 3d 3b ff 45 3d 3b ff 57 4c 47 ff 45 3d 3b \n" +
                "ff 30 2b 2b ff 77 86 8f ff a7 b6 b8 ff 92 a0 a6 \n" +
                "ff 77 86 8f ff 30 2b 2b ff 45 3d 3b ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 a7 b6 b8 ff 92 a0 a6 \n" +
                "ff 00 00 00 00 00 00 00 00 00 00 00 00 45 3d 3b \n" +
                "ff 30 2b 2b ff 85 6c 61 ff b0 93 78 ff 68 82 a3 \n" +
                "ff a5 c7 cf ff c8 e2 e3 ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff c8 e2 e3 ff 8a 46 4e ff a6 51 51 ff a6 51 51 \n" +
                "ff 8a 46 4e ff c8 e2 e3 ff c8 e2 e3 ff c8 e2 e3 \n" +
                "ff c8 e2 e3 ff a5 c7 cf ff 68 82 a3 ff b0 93 78 \n" +
                "ff 85 6c 61 ff 30 2b 2b ff 45 3d 3b ff 57 4c 47 \n" +
                "ff 45 3d 3b ff 5f 6e 7d ff 53 59 66 ff 53 59 66 \n" +
                "ff 5f 6e 7d ff 45 3d 3b ff 57 4c 47 ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 30 2b 2b \n" +
                "ff 85 6c 61 ff b0 93 78 ff c9 ae 81 ff b0 93 78 \n" +
                "ff 88 ac bd ff a5 c7 cf ff a5 c7 cf ff a5 c7 cf \n" +
                "ff a5 c7 cf ff 88 ac bd ff 88 ac bd ff 88 ac bd \n" +
                "ff 88 ac bd ff a5 c7 cf ff a5 c7 cf ff a5 c7 cf \n" +
                "ff a5 c7 cf ff 88 ac bd ff b0 93 78 ff c9 ae 81 \n" +
                "ff b0 93 78 ff 85 6c 61 ff 30 2b 2b ff 30 2b 2b \n" +
                "ff 30 2b 2b ff 0a 09 0a ff 0a 09 0a ff 0a 09 0a \n" +
                "ff 0a 09 0a ff 30 2b 2b ff 30 2b 2b ff 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 c8 e2 e3 ff e1 f0 ee ff e1 f0 ee \n" +
                "ff c8 e2 e3 ff 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 \n" +
                "00 00 00 00 00 00 00 00 00 00 00 00 00 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 73 67 \n" +
                "ff 96 8c 80 ff 82 73 67 ff 70 5d 54 ff 1f 1b 1b \n" +
                "ff 3d 32 30 ff 1f 1b 1b ff 03 02 02 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 4f 45 42 \n" +
                "ff 5e 52 4b ff 85 7d 7b ff a3 9c 98 ff a3 9c 98 \n" +
                "ff 85 7d 7b ff 5e 52 4b ff 4f 45 42 ff 82 73 67 \n" +
                "ff 82 73 67 ff 96 8c 80 ff 96 8c 80 ff 96 8c 80 \n" +
                "ff 96 8c 80 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 73 64 58 \n" +
                "ff 82 73 67 ff 73 64 58 ff 5e 52 4b ff 36 5a 99 \n" +
                "ff 36 5a 99 ff 2e 36 66 ff 47 aa d1 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 96 8c 80 \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 5e 4d 4a ff 1f 1b 1b \n" +
                "ff 5f 6e 7d ff 53 59 66 ff 03 02 02 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 3d 36 35 \n" +
                "ff 85 7d 7b ff 85 6c 61 ff b0 93 78 ff b0 93 78 \n" +
                "ff 85 6c 61 ff 85 7d 7b ff 3d 36 35 ff 82 73 67 \n" +
                "ff 70 5d 54 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 70 5d 54 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 4f 45 42 ff 30 7d b8 \n" +
                "ff 30 7d b8 ff 36 5a 99 ff 36 5a 99 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff b0 a4 8b \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 70 5d 54 ff 1f 1b 1b \n" +
                "ff a7 b6 b8 ff 92 a0 a6 ff 03 02 02 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 3d 36 35 \n" +
                "ff 85 7d 7b ff b0 93 78 ff c9 ae 81 ff c9 ae 81 \n" +
                "ff b0 93 78 ff 85 7d 7b ff 3d 36 35 ff 82 73 67 \n" +
                "ff 82 73 67 ff 70 5d 54 ff 70 5d 54 ff 70 5d 54 \n" +
                "ff 70 5d 54 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 96 8b 65 \n" +
                "ff 96 8b 65 ff 82 73 67 ff 5e 52 4b ff 36 5a 99 \n" +
                "ff 36 5a 99 ff 2e 36 66 ff 30 7d b8 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff b0 a4 8b \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 82 73 67 ff 3d 32 30 \n" +
                "ff 1f 1b 1b ff 1f 1b 1b ff 03 02 02 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 4f 45 42 \n" +
                "ff 85 7d 7b ff a3 9c 98 ff b0 93 78 ff c9 ae 81 \n" +
                "ff a3 9c 98 ff 85 7d 7b ff 4f 45 42 ff 96 8c 80 \n" +
                "ff 82 73 67 ff 70 5d 54 ff 5e 4d 4a ff 5e 4d 4a \n" +
                "ff 70 5d 54 ff 82 73 67 ff 96 8c 80 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff ab a5 7d \n" +
                "ff 96 8b 65 ff 82 73 67 ff 73 64 58 ff 30 7d b8 \n" +
                "ff 30 7d b8 ff 36 5a 99 ff 47 aa d1 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff b0 a4 8b ff b0 a4 8b \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 82 73 67 ff 70 5d 54 \n" +
                "ff 70 5d 54 ff 5e 4d 4a ff 70 5d 54 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff 96 8c 80 ff 4f 45 42 \n" +
                "ff 29 26 26 ff 3d 36 35 ff 4f 45 42 ff 5e 52 4b \n" +
                "ff 85 7d 7b ff bd b6 ae ff b0 93 78 ff c9 ae 81 \n" +
                "ff bd b6 ae ff 85 7d 7b ff 5e 52 4b ff 4f 45 42 \n" +
                "ff 3d 36 35 ff 29 26 26 ff 4f 45 42 ff 5e 52 4b \n" +
                "ff 73 64 58 ff a3 9c 98 ff bd b6 ae ff bd b6 ae \n" +
                "ff a3 9c 98 ff 73 64 58 ff 5e 52 4b ff 73 64 58 \n" +
                "ff 82 73 67 ff 96 8b 65 ff ab a5 7d ff ab a5 7d \n" +
                "ff 96 8b 65 ff 82 73 67 ff 73 64 58 ff 5e 52 4b \n" +
                "ff 5e 52 4b ff 5e 52 4b ff 5e 52 4b ff 73 64 58 \n" +
                "ff 82 74 60 ff 96 8b 65 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff bf b9 9f ff bf b9 9f \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 82 73 67 ff 70 5d 54 \n" +
                "ff 70 5d 54 ff 5e 4d 4a ff 70 5d 54 ff 82 73 67 \n" +
                "ff 96 8c 80 ff bf b9 9f ff 96 8c 80 ff 5e 52 4b \n" +
                "ff 3d 36 35 ff 4f 45 42 ff 5e 52 4b ff 73 64 58 \n" +
                "ff a3 9c 98 ff d1 c9 ba ff 3d 36 35 ff 4f 45 42 \n" +
                "ff d1 c9 ba ff a3 9c 98 ff 73 64 58 ff 5e 52 4b \n" +
                "ff 4f 45 42 ff 3d 36 35 ff 5e 52 4b ff 73 64 58 \n" +
                "ff 82 74 60 ff 73 64 58 ff 5e 52 4b ff 5e 52 4b \n" +
                "ff 73 64 58 ff 82 74 60 ff 73 64 58 ff 73 64 58 \n" +
                "ff 82 73 67 ff 96 8b 65 ff ab a5 7d ff ab a5 7d \n" +
                "ff 96 8b 65 ff 82 73 67 ff 73 64 58 ff 5e 52 4b \n" +
                "ff 5e 52 4b ff 5e 52 4b ff 5e 52 4b ff 73 64 58 \n" +
                "ff 82 74 60 ff ab a5 7d ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff bf b9 9f ff bf b9 9f \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 82 73 67 ff 70 5d 54 \n" +
                "ff 70 5d 54 ff 5e 4d 4a ff 70 5d 54 ff 82 73 67 \n" +
                "ff 96 8c 80 ff bf b9 9f ff 96 8c 80 ff 5e 52 4b \n" +
                "ff 4f 45 42 ff 5e 52 4b ff 73 64 58 ff 82 74 60 \n" +
                "ff 5e 52 4b ff a3 9c 98 ff 0f 0f 0f ff 29 26 26 \n" +
                "ff a3 9c 98 ff 5e 52 4b ff 82 74 60 ff 73 64 58 \n" +
                "ff 5e 52 4b ff 4f 45 42 ff 5e 52 4b ff 73 64 58 \n" +
                "ff 82 74 60 ff 96 8b 65 ff 96 8b 65 ff ab a5 7d \n" +
                "ff 96 8b 65 ff 82 74 60 ff 73 64 58 ff 73 64 58 \n" +
                "ff 82 73 67 ff 96 8b 65 ff ab a5 7d ff ab a5 7d \n" +
                "ff 96 8b 65 ff 82 73 67 ff 73 64 58 ff 5e 52 4b \n" +
                "ff 5e 52 4b ff 5e 52 4b ff 5e 52 4b ff 73 64 58 \n" +
                "ff 82 74 60 ff ab a5 7d ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 70 5d 54 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff bf b9 9f ff bf b9 9f \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 70 5d 54 ff 5e 4d 4a \n" +
                "ff 5e 4d 4a ff 5e 4d 4a ff 5e 4d 4a ff 70 5d 54 \n" +
                "ff 96 8c 80 ff bf b9 9f ff 96 8c 80 ff 3d 36 35 \n" +
                "ff 29 26 26 ff 73 64 58 ff 82 74 60 ff 96 8b 65 \n" +
                "ff 73 64 58 ff 15 17 17 ff 3d 36 35 ff 4f 45 42 \n" +
                "ff 26 2a 2b ff 73 64 58 ff 96 8b 65 ff 82 74 60 \n" +
                "ff 73 64 58 ff 29 26 26 ff 3d 36 35 ff 3d 36 35 \n" +
                "ff 4f 45 42 ff 5e 52 4b ff 4f 45 42 ff 4f 45 42 \n" +
                "ff 5e 52 4b ff 4f 45 42 ff 3d 36 35 ff 5e 52 4b \n" +
                "ff 82 73 67 ff 96 8b 65 ff 96 8b 65 ff 96 8b 65 \n" +
                "ff 96 8b 65 ff 82 73 67 ff 5e 52 4b ff 4f 45 42 \n" +
                "ff 4f 45 42 ff 4f 45 42 ff 4f 45 42 ff 5e 52 4b \n" +
                "ff 82 74 60 ff 96 8b 65 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 70 5d 54 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff bf b9 9f ff bf b9 9f \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 70 5d 54 ff 5e 4d 4a \n" +
                "ff 5e 4d 4a ff 5e 4d 4a ff 5e 4d 4a ff 70 5d 54 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff 96 8c 80 ff 4f 45 42 \n" +
                "ff 3d 36 35 ff 73 64 58 ff 82 74 60 ff ab a5 7d \n" +
                "ff 73 64 58 ff 26 2a 2b ff 30 3d 3d ff 3c 52 4f \n" +
                "ff 30 3d 3d ff 73 64 58 ff ab a5 7d ff 82 74 60 \n" +
                "ff 73 64 58 ff 3d 36 35 ff 4f 45 42 ff 5e 52 4b \n" +
                "ff 82 74 60 ff 73 64 58 ff 5e 52 4b ff 5e 52 4b \n" +
                "ff 73 64 58 ff 82 74 60 ff 5e 52 4b ff 4f 45 42 \n" +
                "ff 82 73 67 ff 96 8b 65 ff 96 8b 65 ff 96 8b 65 \n" +
                "ff 96 8b 65 ff 82 73 67 ff 4f 45 42 ff 3d 36 35 \n" +
                "ff 3d 36 35 ff 3d 36 35 ff 3d 36 35 ff 4f 45 42 \n" +
                "ff 82 74 60 ff 96 8b 65 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 5e 4d 4a \n" +
                "ff 96 8c 80 ff b0 a4 8b ff b0 a4 8b ff b0 a4 8b \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 5e 4d 4a ff 47 3a 39 \n" +
                "ff 47 3a 39 ff 47 3a 39 ff 47 3a 39 ff 5e 4d 4a \n" +
                "ff 96 8c 80 ff b0 a4 8b ff 96 8c 80 ff 5e 52 4b \n" +
                "ff 4f 45 42 ff 73 64 58 ff 82 74 60 ff 96 8b 65 \n" +
                "ff 73 64 58 ff 26 2a 2b ff 30 3d 3d ff 48 67 69 \n" +
                "ff 30 3d 3d ff 73 64 58 ff 96 8b 65 ff 82 74 60 \n" +
                "ff 73 64 58 ff 4f 45 42 ff 5e 52 4b ff 73 64 58 \n" +
                "ff 96 8b 65 ff 82 74 60 ff 73 64 58 ff 73 64 58 \n" +
                "ff 82 74 60 ff 96 8b 65 ff 73 64 58 ff 4f 45 42 \n" +
                "ff 73 64 58 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 73 64 58 ff 4f 45 42 ff 3d 36 35 \n" +
                "ff 3d 36 35 ff 3d 36 35 ff 3d 36 35 ff 4f 45 42 \n" +
                "ff 73 64 58 ff 82 74 60 ff 73 64 58 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 5e 4d 4a \n" +
                "ff 82 73 67 ff 96 8c 80 ff 96 8c 80 ff 96 8c 80 \n" +
                "ff 96 8c 80 ff 82 73 67 ff 5e 4d 4a ff 47 3a 39 \n" +
                "ff 47 3a 39 ff 47 3a 39 ff 47 3a 39 ff 5e 4d 4a \n" +
                "ff 82 73 67 ff 96 8c 80 ff 82 73 67 ff 5e 52 4b \n" +
                "ff 4f 45 42 ff 73 64 58 ff 82 74 60 ff 96 8b 65 \n" +
                "ff 5e 52 4b ff 26 2a 2b ff 30 3d 3d ff 3c 52 4f \n" +
                "ff 26 2a 2b ff 5e 52 4b ff 96 8b 65 ff 82 74 60 \n" +
                "ff 73 64 58 ff 4f 45 42 ff 5e 52 4b ff 73 64 58 \n" +
                "ff ab a5 7d ff 82 74 60 ff 73 64 58 ff 73 64 58 \n" +
                "ff 82 74 60 ff ab a5 7d ff 73 64 58 ff 3d 36 35 \n" +
                "ff 5e 52 4b ff 73 64 58 ff 73 64 58 ff 73 64 58 \n" +
                "ff 73 64 58 ff 5e 52 4b ff 3d 36 35 ff 3d 36 35 \n" +
                "ff 3d 36 35 ff 3d 36 35 ff 3d 36 35 ff 3d 36 35 \n" +
                "ff 5e 52 4b ff 73 64 58 ff 5e 52 4b ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 47 3a 39 \n" +
                "ff 70 5d 54 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 82 73 67 ff 70 5d 54 ff 47 3a 39 ff 47 3a 39 \n" +
                "ff 47 3a 39 ff 47 3a 39 ff 47 3a 39 ff 47 3a 39 \n" +
                "ff 70 5d 54 ff 82 73 67 ff 70 5d 54 ff 5e 52 4b \n" +
                "ff 3d 36 35 ff 5e 52 4b ff 73 64 58 ff 82 74 60 \n" +
                "ff 5e 52 4b ff 15 17 17 ff 15 17 17 ff 15 17 17 \n" +
                "ff 15 17 17 ff 5e 52 4b ff 82 74 60 ff 73 64 58 \n" +
                "ff 5e 52 4b ff 3d 36 35 ff 5e 52 4b ff 73 64 58 \n" +
                "ff 96 8b 65 ff 82 74 60 ff 5e 52 4b ff 5e 52 4b \n" +
                "ff 82 74 60 ff 96 8b 65 ff 73 64 58 ff 85 7d 7b \n" +
                "ff a3 9c 98 ff bd b6 ae ff d1 c9 ba ff d1 c9 ba \n" +
                "ff bd b6 ae ff a3 9c 98 ff 85 7d 7b ff 85 7d 7b \n" +
                "ff 85 7d 7b ff 85 7d 7b ff 85 7d 7b ff 85 7d 7b \n" +
                "ff a3 9c 98 ff bd b6 ae ff a3 9c 98 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff bf b9 9f ff bf b9 9f \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 82 73 67 ff 70 5d 54 \n" +
                "ff 70 5d 54 ff 70 5d 54 ff 70 5d 54 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff 96 8c 80 ff 4f 45 42 \n" +
                "ff 29 26 26 ff 4f 45 42 ff 5e 52 4b ff 73 64 58 \n" +
                "ff 4f 45 42 ff 3d 32 30 ff 92 a0 a6 ff a7 b6 b8 \n" +
                "ff 3d 32 30 ff 4f 45 42 ff 73 64 58 ff 5e 52 4b \n" +
                "ff 4f 45 42 ff 29 26 26 ff 4f 45 42 ff 5e 52 4b \n" +
                "ff 96 8b 65 ff 82 74 60 ff 4f 45 42 ff 4f 45 42 \n" +
                "ff 82 74 60 ff 96 8b 65 ff 5e 52 4b ff 2e 36 66 \n" +
                "ff 36 5a 99 ff 36 5a 99 ff 36 5a 99 ff 36 5a 99 \n" +
                "ff 36 5a 99 ff 36 5a 99 ff 2e 36 66 ff 2e 36 66 \n" +
                "ff 2e 36 66 ff 2e 36 66 ff 2e 36 66 ff 2e 36 66 \n" +
                "ff 36 5a 99 ff 36 5a 99 ff 36 5a 99 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 3d 32 30 \n" +
                "ff 54 49 45 ff 6e 5d 51 ff 6e 5d 51 ff 6e 5d 51 \n" +
                "ff 6e 5d 51 ff 54 49 45 ff 3d 32 30 ff 1f 1b 1b \n" +
                "ff 1f 1b 1b ff 1f 1b 1b ff 1f 1b 1b ff 3d 32 30 \n" +
                "ff 54 49 45 ff 6e 5d 51 ff 54 49 45 ff 3d 36 35 \n" +
                "ff 29 26 26 ff 3d 36 35 ff 4f 45 42 ff 5e 52 4b \n" +
                "ff 3d 36 35 ff 03 02 02 ff 53 59 66 ff 5f 6e 7d \n" +
                "ff 03 02 02 ff 3d 36 35 ff 5e 52 4b ff 4f 45 42 \n" +
                "ff 3d 36 35 ff 29 26 26 ff 3d 36 35 ff 4f 45 42 \n" +
                "ff 82 74 60 ff 73 64 58 ff 3d 36 35 ff 3d 36 35 \n" +
                "ff 73 64 58 ff 82 74 60 ff 4f 45 42 ff 36 5a 99 \n" +
                "ff 30 7d b8 ff 30 7d b8 ff 30 7d b8 ff 30 7d b8 \n" +
                "ff 47 aa d1 ff 47 aa d1 ff 30 7d b8 ff 36 5a 99 \n" +
                "ff 36 5a 99 ff 36 5a 99 ff 36 5a 99 ff 30 7d b8 \n" +
                "ff 47 aa d1 ff 47 aa d1 ff 30 7d b8 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 1f 1b 1b \n" +
                "ff 3d 32 30 ff 54 49 45 ff 54 49 45 ff 54 49 45 \n" +
                "ff 54 49 45 ff 3d 32 30 ff 1f 1b 1b ff 03 02 02 \n" +
                "ff 03 02 02 ff 03 02 02 ff 03 02 02 ff 1f 1b 1b \n" +
                "ff 3d 32 30 ff 54 49 45 ff 3d 32 30 ff 3d 36 35 \n" +
                "ff 29 26 26 ff 82 73 67 ff 96 8c 80 ff b0 a4 8b \n" +
                "ff 96 8c 80 ff b0 a4 8b ff b0 a4 8b ff bf b9 9f \n" +
                "ff b0 a4 8b ff 96 8c 80 ff b0 a4 8b ff 96 8c 80 \n" +
                "ff 82 73 67 ff 29 26 26 ff 3d 36 35 ff 3d 36 35 \n" +
                "ff 73 64 58 ff 5e 52 4b ff 96 8c 80 ff 96 8c 80 \n" +
                "ff 5e 52 4b ff 73 64 58 ff 3d 36 35 ff 36 5a 99 \n" +
                "ff 47 aa d1 ff 30 7d b8 ff 47 aa d1 ff 30 7d b8 \n" +
                "ff 36 5a 99 ff 2e 36 66 ff 30 7d b8 ff 30 7d b8 \n" +
                "ff 36 5a 99 ff 2e 36 66 ff 36 5a 99 ff 30 7d b8 \n" +
                "ff 2e 36 66 ff 36 5a 99 ff 30 7d b8 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 03 02 02 \n" +
                "ff 1f 1b 1b ff 1f 1b 1b ff 3d 32 30 ff 3d 32 30 \n" +
                "ff 1f 1b 1b ff 1f 1b 1b ff 03 02 02 ff 03 02 02 \n" +
                "ff 03 02 02 ff 03 02 02 ff 03 02 02 ff 03 02 02 \n" +
                "ff 1f 1b 1b ff 3d 32 30 ff 1f 1b 1b ff 82 73 67 \n" +
                "ff 82 73 67 ff 82 73 67 ff 96 8c 80 ff 96 8c 80 \n" +
                "ff 82 73 67 ff 70 5d 54 ff 5e 4d 4a ff 5e 4d 4a \n" +
                "ff 70 5d 54 ff 82 73 67 ff 96 8c 80 ff 96 8c 80 \n" +
                "ff 82 73 67 ff 82 73 67 ff 82 73 67 ff 82 73 67 \n" +
                "ff 96 8c 80 ff b0 a4 8b ff bf b9 9f ff b0 a4 8b \n" +
                "ff b0 a4 8b ff 96 8c 80 ff 82 73 67 ff 36 5a 99 \n" +
                "ff 30 7d b8 ff 36 5a 99 ff 30 7d b8 ff 30 7d b8 \n" +
                "ff 30 7d b8 ff 36 5a 99 ff 47 aa d1 ff 47 aa d1 \n" +
                "ff 30 7d b8 ff 36 5a 99 ff 30 7d b8 ff 47 aa d1 \n" +
                "ff 36 5a 99 ff 30 7d b8 ff 30 7d b8 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff 82 74 60 \n" +
                "ff 82 74 60 ff 82 74 60 ff 82 74 60 ff ";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for ( String line : hexThings.split( "\n" ) ) {
            for ( String hex : line.split( " " ) ) {
                byte value = (byte) ( ( Character.digit( hex.charAt( 0 ), 16 ) << 4 ) + Character.digit( hex.charAt( 1 ), 16 ) );
                byteArrayOutputStream.write( value );
            }
        }

        Connection connection = new Connection( InetSocketAddress.createUnresolved( "127.0.0.1", 19133 ), ConnectionState.RELIABLE ) {
            @Override
            protected void sendRaw( SocketAddress recipient, PacketBuffer buffer ) throws IOException {

            }

            @Override
            protected Logger getImplementationLogger() {
                return null;
            }

            @Override
            protected boolean handleDatagram0( DatagramBuffer datagram, long time ) {
                return false;
            }

            @Override
            protected boolean handlePacket0( EncapsulatedPacket packet ) {
                return false;
            }

            @Override
            protected void propagateConnectionClosed() {

            }

            @Override
            protected void propagateConnectionDisconnected() {

            }

            @Override
            protected void propagateFullyConnected() {

            }
        };
        connection.setMtuSize( 1492 );

        DatagramBuffer datagramBuffer = new DatagramBuffer( InetSocketAddress.createUnresolved( "127.0.0.1", 19133 ), byteArrayOutputStream.toByteArray() );
        connection.handleConnectedDatagram( datagramBuffer );


    }
}
