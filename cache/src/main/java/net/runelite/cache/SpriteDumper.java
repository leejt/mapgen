package net.runelite.cache;

import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.Djb2;

import java.io.File;

public class SpriteDumper {
    public static void main(String[] args) throws Exception {
        String cache = "/Users/jonathanlee/mapgen/cache/cache/";
        Store store = new Store(new File(cache));

        Storage storage = store.getStorage();
        Index index = store.getIndex(IndexType.SPRITES);
        System.out.println(index.getArchives().size());
        for (Archive a : index.getArchives()) {
            byte[] contents = a.decompress(storage.loadArchive(a));

            SpriteLoader loader = new SpriteLoader();
            SpriteDefinition[] sprites = loader.load(a.getArchiveId(), contents);
            System.out.println(a.getArchiveId() + " " + sprites.length);
        }

    }
}
