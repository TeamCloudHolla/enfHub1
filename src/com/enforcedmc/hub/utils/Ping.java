package com.enforcedmc.hub.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;

public class Ping
{
    public static int maxpl(final String adress, final int port, final int timeout) {
        int max;
        try {
            final Socket socket = new Socket();
            socket.setSoTimeout(120);
            socket.connect(new InetSocketAddress(adress, port), timeout);
            final OutputStream outputStream = socket.getOutputStream();
            final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            final InputStream inputStream = socket.getInputStream();
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-16BE"));
            dataOutputStream.write(new byte[] { -2, 1 });
            final int packetId = inputStream.read();
            if (packetId == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (packetId != 255) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid packet ID (" + packetId + ").");
            }
            final int length = inputStreamReader.read();
            if (length == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (length == 0) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid string length.");
            }
            final char[] chars = new char[length];
            if (inputStreamReader.read(chars, 0, length) != length) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            final String string = new String(chars);
            if (string.startsWith("§")) {
                final String[] data = string.split("\u0000");
                socket.close();
                max = Integer.parseInt(data[5]);
            }
            else {
                final String[] data = string.split("§");
                socket.close();
                max = Integer.parseInt(data[2]);
            }
            dataOutputStream.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        }
        catch (SocketException exception) {
            max = 0;
        }
        catch (IOException exception2) {
            max = 0;
        }
        return max;
    }
    
    public static int onpl(final String adress, final int port, final int timeout) {
        int max;
        try {
            final Socket socket = new Socket();
            socket.setSoTimeout(120);
            socket.connect(new InetSocketAddress(adress, port), timeout);
            final OutputStream outputStream = socket.getOutputStream();
            final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            final InputStream inputStream = socket.getInputStream();
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-16BE"));
            dataOutputStream.write(new byte[] { -2, 1 });
            final int packetId = inputStream.read();
            if (packetId == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (packetId != 255) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid packet ID (" + packetId + ").");
            }
            final int length = inputStreamReader.read();
            if (length == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (length == 0) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid string length.");
            }
            final char[] chars = new char[length];
            if (inputStreamReader.read(chars, 0, length) != length) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            final String string = new String(chars);
            if (string.startsWith("§")) {
                final String[] data = string.split("\u0000");
                socket.close();
                max = Integer.parseInt(data[4]);
            }
            else {
                final String[] data = string.split("§");
                socket.close();
                max = Integer.parseInt(data[1]);
            }
            dataOutputStream.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        }
        catch (SocketException exception) {
            max = 0;
        }
        catch (IOException exception2) {
            max = 0;
        }
        return max;
    }
    
    public static boolean online(final String adress, final int port, final int timeout) {
        boolean on = false;
        try {
            final Socket socket = new Socket();
            socket.setSoTimeout(120);
            socket.connect(new InetSocketAddress(adress, port), timeout);
            final OutputStream outputStream = socket.getOutputStream();
            final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            final InputStream inputStream = socket.getInputStream();
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-16BE"));
            dataOutputStream.write(new byte[] { -2, 1 });
            final int packetId = inputStream.read();
            if (packetId == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (packetId != 255) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid packet ID (" + packetId + ").");
            }
            final int length = inputStreamReader.read();
            if (length == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (length == 0) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid string length.");
            }
            final char[] chars = new char[length];
            if (inputStreamReader.read(chars, 0, length) != length) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            final String string = new String(chars);
            if (string.startsWith("§")) {
                final String[] data = string.split("\u0000");
                socket.close();
                on = true;
            }
            else {
                final String[] data = string.split("§");
                socket.close();
                on = true;
            }
            dataOutputStream.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        }
        catch (SocketException exception) {
            on = false;
        }
        catch (IOException exception2) {
            on = false;
        }
        return on;
    }
    
    public static String motd(final String adress, final int port, final int timeout) {
        String motd = "";
        try {
            final Socket socket = new Socket();
            socket.setSoTimeout(120);
            socket.connect(new InetSocketAddress(adress, port), timeout);
            final OutputStream outputStream = socket.getOutputStream();
            final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            final InputStream inputStream = socket.getInputStream();
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-16BE"));
            dataOutputStream.write(new byte[] { -2, 1 });
            final int packetId = inputStream.read();
            if (packetId == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (packetId != 255) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid packet ID (" + packetId + ").");
            }
            final int length = inputStreamReader.read();
            if (length == -1) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            if (length == 0) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Invalid string length.");
            }
            final char[] chars = new char[length];
            if (inputStreamReader.read(chars, 0, length) != length) {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
                throw new IOException("Premature end of stream.");
            }
            final String string = new String(chars);
            if (string.startsWith("§")) {
                final String[] data = string.split("\u0000");
                socket.close();
                motd = data[3];
            }
            else {
                final String[] data = string.split("§");
                socket.close();
                motd = data[0];
            }
            dataOutputStream.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        }
        catch (SocketException exception) {
            motd = "";
        }
        catch (IOException exception2) {
            motd = "";
        }
        return motd;
    }
}
