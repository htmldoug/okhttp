package okhttp3.internal.io;

import okio.Sink;
import okio.Source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SynchronizedFileSystem implements FileSystem {

    private FileSystem underlying;

    public SynchronizedFileSystem(FileSystem underlying) {
        this.underlying = underlying;
    }

    @Override
    public synchronized Source source(File file) throws FileNotFoundException {
        return underlying.source(file);
    }

    @Override
    public synchronized Sink sink(File file) throws FileNotFoundException {
        return underlying.sink(file);
    }

    @Override
    public synchronized Sink appendingSink(File file) throws FileNotFoundException {
        return underlying.appendingSink(file);
    }

    @Override
    public synchronized void delete(File file) throws IOException {
        underlying.delete(file);
    }

    @Override
    public synchronized boolean exists(File file) {
        return underlying.exists(file);
    }

    @Override
    public synchronized long size(File file) {
        return underlying.size(file);
    }

    @Override
    public synchronized void rename(File from, File to) throws IOException {
        underlying.rename(from, to);
    }

    @Override
    public synchronized void deleteContents(File directory) throws IOException {
        underlying.deleteContents(directory);
    }
}
