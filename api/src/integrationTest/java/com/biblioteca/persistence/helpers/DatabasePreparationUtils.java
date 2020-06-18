package com.biblioteca.persistence.helpers;

import org.apache.ibatis.migration.commands.UpCommand;
import org.apache.ibatis.migration.options.SelectedOptions;

import java.io.File;

public class DatabasePreparationUtils {
    public static void executeMyBatisMigrations(String environment) {
        SelectedOptions options = new SelectedOptions();
        options.setEnvironment(environment);
        options.getPaths().setBasePath(new File("db/migrations"));
        new UpCommand(options).execute();
    }
}
