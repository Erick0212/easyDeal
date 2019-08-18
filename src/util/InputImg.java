/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Erick_Nagoski
 */
public class InputImg {
    
    private File file;
    private FileInputStream fis;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public InputImg(File file, FileInputStream fis) {
        this.file = file;
        this.fis = fis;
    }
    
    
    
}
