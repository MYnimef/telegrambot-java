package com.mynimef.bot.containers;

import java.util.List;

public class Container<T> implements IFileContainer, IFileAdd<T>, IButtonsContainer, IButtonAdd<T> {
    private final FileContainer<T> fileContainer;
    private final ButtonsContainer<T> buttonsContainer;

    public Container() {
        fileContainer = new FileContainer<>();
        buttonsContainer = new ButtonsContainer<>();
    }

    @Override
    public T addButton(String label, String callbackId) {
        return buttonsContainer.addButton(label, callbackId);
    }

    @Override
    public T addLine() {
        return buttonsContainer.addLine();
    }

    @Override
    public boolean doesHaveButtons() {
        return buttonsContainer.doesHaveButtons();
    }

    @Override
    public List<ButtonLine> getButtons() {
        return buttonsContainer.getButtons();
    }

    @Override
    public void setButtons(List<ButtonLine> buttonLines) {
        buttonsContainer.setButtons(buttonLines);
    }

    @Override
    public T addFile(String path, String description) {
        return fileContainer.addFile(path, description);
    }

    @Override
    public List<VMFile> getFiles() {
        return fileContainer.getFiles();
    }

    @Override
    public void setFiles(List<VMFile> files) {
        fileContainer.setFiles(files);
    }
}
