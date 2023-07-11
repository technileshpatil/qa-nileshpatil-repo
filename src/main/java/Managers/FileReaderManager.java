package Managers;

import dataproviders.ConfigReaderProvider;

public class FileReaderManager {

    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigReaderProvider configReaderProvider;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigReaderProvider getConfigFileReader() {
        return (configReaderProvider == null) ? new ConfigReaderProvider() : configReaderProvider;
    }
}
