package okhttp3;

import okhttp3.internal.io.FileSystem;
import okhttp3.internal.io.InMemoryFileSystem;
import okhttp3.internal.io.SynchronizedFileSystem;

import java.io.File;

public class InMemoryExample {

    public OkHttpClient buildClient() {

        FileSystem filesystem = new SynchronizedFileSystem(new InMemoryFileSystem());
        new OkHttpClient.Builder()
                .cache(new Cache(new File("/"), 1 * 1000 * 1000, filesystem));

        return null;
    }
}
