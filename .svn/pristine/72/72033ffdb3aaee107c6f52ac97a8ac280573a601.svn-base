/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import com.sigma.big.model.db.Attributes;
import com.sigma.big.model.db.Mapping;
import com.sigma.big.model.db.Produk;
import com.sigma.big.model.db.Project;
import com.sigma.big.utils.Constants;
import com.sigma.migrationtool.test.TestExcelReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Ridho
 */
public class ExcelReader {

    public HashMap<String, Project> getProjectFromExcel(String path) throws FileNotFoundException, IOException {
        POIFSFileSystem fs;
        fs = new POIFSFileSystem(new FileInputStream(new File(path)));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;
        int rows; // No of rows
        rows = sheet.getPhysicalNumberOfRows();
        int cols = 0; // No of columns
        int tmp = 0;
        // This trick ensures that we get the data properly even if it doesn't start from first few rows
        for (int i = 0; i < 10 || i < rows; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                if (tmp > cols) {
                    cols = tmp;
                }
            }
        }
        HashMap<String, Project> projects = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            row = sheet.getRow(r);
            if (row != null) {
                Project project = null;
                ArrayList<String> namaUnsurs = new ArrayList<>();
                for (int c = 0; c < cols; c++) {
                    cell = row.getCell((short) c);
                    if (cell != null) {
//                        System.out.println(r + " " + c + " " + cell);
                        switch (c) {
                            case Constants.NAMA_PROJECT:
                                project = new Project();
                                project.setNamaProject(cell.toString());
                                break;
                            case Constants.FILE_IDENTIFIER:
                                project.setFileIdentifier(cell.toString());
                                break;
                            case Constants.NAMA_UNSUR:
                                if (!checkProjectAlreadyAded(projects, project.getNamaProject())) {
                                    namaUnsurs.add(cell.toString());
                                    project.setNamaUnsurs(namaUnsurs);

                                } else {
                                    project = getPeojectFromHashMap(projects, project.getNamaProject());
                                    namaUnsurs = project.getNamaUnsurs();
                                    namaUnsurs.add(cell.toString());
                                    //dikembalikan lagi
                                    project.setNamaUnsurs(namaUnsurs);
                                }
                                projects.put(project.getNamaProject(), project);
                                break;

                        }
                    }

                }

            }
        }
        return projects;

    }

    public static void main(String[] arg) {
        try {
            HashMap<String, Mapping> mapping = getMappingFromExcelNew("C:/migrasi/data/mapping_produksi/12122017_MappingDev2SDO_hilman.xls");
            System.out.println("");
            System.out.println("MAPPING SIZE : " + mapping.size());
            for (Map.Entry<String, Mapping> entry : mapping.entrySet()) {
                String key = entry.getKey();
                Mapping value = entry.getValue();
                System.out.print("KEY " + key + " == ");
                System.out.println(value.getSkemaSumber() + "|" + value.getTabelSumber());
            }
        } catch (IOException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static HashMap<String, Mapping> getMappingFromExcelNew(String path) throws IOException, EncryptedDocumentException, InvalidFormatException {

        HashMap<String, Mapping> mappings = new HashMap<>();

        File f = new File(path);
        Workbook workbook = WorkbookFactory.create(f);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getSheetName());
        int i = 0;
        for (Row row : sheet) {
            if (i > 0) {
                //            System.out.println("");
//            System.out.print("ROW = " + i);
                Mapping mapping = new Mapping();
                HashMap<String, Attributes> attributes = new HashMap<>();
                Attributes attributes1 = new Attributes();

                for (Cell c : row) {
//                System.out.print("|");
//                System.out.print(c);
//                System.out.print("|");
                    mapping.setFcode(row.getCell(Constants.FCODE) == null ? "" : row.getCell(Constants.FCODE).toString());
//                    mapping.setSkala(row.getCell(Constants.SKALA) == null ? "" : row.getCell(Constants.SKALA).toString());

                    mapping.setSkemaSumber(row.getCell(Constants.SKEMA_SDE) == null ? "" : row.getCell(Constants.SKEMA_SDE).toString());
                    mapping.setTabelSumber(row.getCell(Constants.TABEL_SUMBER) == null ? "" : row.getCell(Constants.TABEL_SUMBER).toString());
                    mapping.setSkemaTarget(row.getCell(Constants.SKEMA_SDO) == null ? "" : row.getCell(Constants.SKEMA_SDO).toString());
                    mapping.setTabelTarget(row.getCell(Constants.TABEL_TARGET) == null ? "" : row.getCell(Constants.TABEL_TARGET).toString());
                    attributes1.setNamaSumber(row.getCell(Constants.ATTR_SUMBER) == null ? "" : row.getCell(Constants.ATTR_SUMBER).toString().toUpperCase());
                    attributes1.setDataTypeSumber(row.getCell(Constants.DATA_TYPE_SUMBER) == null ? "" : row.getCell(Constants.DATA_TYPE_SUMBER).toString());
                    attributes1.setSizeSumber(row.getCell(Constants.DATA_SIZE_SUMBER) == null ? "" : row.getCell(Constants.DATA_SIZE_SUMBER).toString());
                    //Target
                    attributes1.setNamaTarget(row.getCell(Constants.ATTR_TARGET) == null ? "" : row.getCell(Constants.ATTR_TARGET).toString().toUpperCase());
                    attributes1.setDataTypeTarget(row.getCell(Constants.DATA_TYPE_TARGET) == null ? "" : row.getCell(Constants.DATA_TYPE_TARGET).toString());
                    attributes1.setSizeTarget(row.getCell(Constants.DATA_SIZE_TARGET) == null ? "" : row.getCell(Constants.DATA_SIZE_TARGET).toString());
                    attributes1.setIsDomain(Boolean.getBoolean(row.getCell(Constants.IS_DOMAIN) == null ? "FALSE" : row.getCell(Constants.IS_DOMAIN).toString()));

                    if (checkUnsurAlreadyAded(mappings, mapping.getSkemaSumber() + "-" + mapping.getTabelSumber())) {
                        mapping = mappings.get(mapping.getSkemaSumber() + "-" + mapping.getTabelSumber());
                        mappings.remove(mapping.getSkemaSumber() + "-" + mapping.getTabelSumber());
                        if (mapping.getAttributes() != null) {
                            attributes = mapping.getAttributes();
                        }
                        attributes.put(attributes1.getNamaSumber(), attributes1);
                        mapping.setAttributes(attributes);
                        mappings.put(mapping.getSkemaSumber() + "-" + mapping.getTabelSumber(), mapping);
                    } else {
                        if (mapping.getAttributes() != null) {
                            attributes = mapping.getAttributes();
                        }
                        attributes.put(attributes1.getNamaSumber(), attributes1);
                        mapping.setAttributes(attributes);
                        mappings.put(mapping.getSkemaSumber() + "-" + mapping.getTabelSumber(), mapping);
                    }
                }
                mappings.put(mapping.getSkemaSumber() + "-" + mapping.getTabelSumber(), mapping);
            }

            i++;
        }
        workbook.cloneSheet(0);
        return mappings;
    }

    public HashMap<String, Mapping> getMappingFromExcel(String path) throws FileNotFoundException, IOException {
        POIFSFileSystem fs;
        fs = new POIFSFileSystem(new FileInputStream(new File(path)));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;

        int rows; // No of rows
        rows = sheet.getPhysicalNumberOfRows();

        int cols = 0; // No of columns
        int tmp = 0;

        // This trick ensures that we get the data properly even if it doesn't start from first few rows
        for (int i = 0; i < 10 || i < rows; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                if (tmp > cols) {
                    cols = tmp;
                }
            }
        }
        HashMap<String, Produk> produks = new HashMap<>();
        HashMap<String, Mapping> mappings = new HashMap<>();

        for (int r = 0; r < rows; r++) {
            row = sheet.getRow(r);
//            System.out.println(row.getCell(0));
            if (row != null) {
                Produk produk;
                Mapping mapping = new Mapping();
                HashMap<String, Attributes> attributes = new HashMap<>();
                Attributes attributes1 = new Attributes();

                mapping.setFcode(row.getCell(Constants.FCODE) == null ? "" : row.getCell(Constants.FCODE).toString());
                mapping.setSkemaSumber(row.getCell(Constants.SKEMA_SDE) == null ? "" : row.getCell(Constants.SKEMA_SDE).toString());
                mapping.setTabelSumber(row.getCell(Constants.TABEL_SUMBER) == null ? "" : row.getCell(Constants.TABEL_SUMBER).toString());
                mapping.setSkemaTarget(row.getCell(Constants.SKEMA_SDO) == null ? "" : row.getCell(Constants.SKEMA_SDO).toString());
                mapping.setTabelTarget(row.getCell(Constants.TABEL_TARGET) == null ? "" : row.getCell(Constants.TABEL_TARGET).toString());

                for (int c = 0; c < cols; c++) {
//                    cell = row.getCell((short) c);
                    //Attribute
                    //Sumber
                    attributes1.setNamaSumber(row.getCell(Constants.ATTR_SUMBER) == null ? "" : row.getCell(Constants.ATTR_SUMBER).toString().toUpperCase());
                    attributes1.setDataTypeSumber(row.getCell(Constants.DATA_TYPE_SUMBER) == null ? "" : row.getCell(Constants.DATA_TYPE_SUMBER).toString());
                    attributes1.setSizeSumber(row.getCell(Constants.DATA_SIZE_SUMBER) == null ? "" : row.getCell(Constants.DATA_SIZE_SUMBER).toString());
                    //Target
                    attributes1.setNamaTarget(row.getCell(Constants.ATTR_TARGET) == null ? "" : row.getCell(Constants.ATTR_TARGET).toString().toUpperCase());
                    attributes1.setDataTypeTarget(row.getCell(Constants.DATA_TYPE_TARGET) == null ? "" : row.getCell(Constants.DATA_TYPE_TARGET).toString());
                    attributes1.setSizeTarget(row.getCell(Constants.DATA_SIZE_TARGET) == null ? "" : row.getCell(Constants.DATA_SIZE_TARGET).toString());
                    attributes1.setIsDomain(Boolean.getBoolean(row.getCell(Constants.IS_DOMAIN) == null ? "FALSE" : row.getCell(Constants.IS_DOMAIN).toString()));

                    if (checkUnsurAlreadyAded(mappings, mapping.getTabelSumber())) {
                        mapping = mappings.get(mapping.getTabelSumber());
                        mappings.remove(mapping.getTabelSumber());
                        if (mapping.getAttributes() != null) {
                            attributes = mapping.getAttributes();
                        }
                        attributes.put(attributes1.getNamaSumber(), attributes1);
                        mapping.setAttributes(attributes);
                        mappings.put(mapping.getTabelSumber(), mapping);
                    } else {
                        if (mapping.getAttributes() != null) {
                            attributes = mapping.getAttributes();
                        }
                        attributes.put(attributes1.getNamaSumber(), attributes1);
                        mapping.setAttributes(attributes);
                        mappings.put(mapping.getTabelSumber(), mapping);
                    }
                }
                mappings.put(mapping.getTabelSumber(), mapping);
            }
        }
       
        return mappings;

    }

    public HashMap<String, Mapping> getMappingFromExcelPublikasi(String path) throws FileNotFoundException, IOException {
        POIFSFileSystem fs;
        fs = new POIFSFileSystem(new FileInputStream(new File(path)));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;

        int rows; // No of rows
        rows = sheet.getPhysicalNumberOfRows();

        int cols = 0; // No of columns
        int tmp = 0;

        // This trick ensures that we get the data properly even if it doesn't start from first few rows
        for (int i = 0; i < 10 || i < rows; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                if (tmp > cols) {
                    cols = tmp;
                }
            }
        }
        HashMap<String, Produk> produks = new HashMap<>();
        HashMap<String, Mapping> mappings = new HashMap<>();

        for (int r = 1; r <= rows; r++) {
            row = sheet.getRow(r);
//            System.out.println(row.getCell(0));
            if (row != null) {
                Produk produk;
                Mapping mapping = new Mapping();
                HashMap<String, Attributes> attributes = new HashMap<>();
                Attributes attributes1 = new Attributes();

                mapping.setKeloompok(row.getCell(Constants.KELOMPOK_SUMBER_PROD) == null ? "" : row.getCell(Constants.KELOMPOK_SUMBER_PROD).toString());
                mapping.setSkemaSumber(row.getCell(Constants.SKEMA_SUMBER_PROD) == null ? "" : row.getCell(Constants.SKEMA_SUMBER_PROD).toString().toUpperCase());
                mapping.setTabelSumber(row.getCell(Constants.TABEL_SUMBER_PROD) == null ? "" : row.getCell(Constants.TABEL_SUMBER_PROD).toString().toUpperCase());
                mapping.setSkemaTarget(row.getCell(Constants.SKEMA_TARGET_PUB) == null ? "" : row.getCell(Constants.SKEMA_TARGET_PUB).toString().toUpperCase());
                mapping.setTabelTarget(row.getCell(Constants.TABEL_TARGET_PUB) == null ? "" : row.getCell(Constants.TABEL_TARGET_PUB).toString().toUpperCase());
                String key = mapping.getSkemaTarget().trim() + "-" + mapping.getTabelTarget().trim();
                for (int c = 0; c < cols; c++) {
//                    cell = row.getCell((short) c);
                    //Attribute
                    //Sumber
                    attributes1.setNamaSumber(row.getCell(Constants.ATTR_SUMBER_PROD) == null ? "" : row.getCell(Constants.ATTR_SUMBER_PROD).toString().toUpperCase());
                    attributes1.setDataTypeSumber(row.getCell(Constants.DATA_TYPE_SUMBER_PROD) == null ? "" : row.getCell(Constants.DATA_TYPE_SUMBER_PROD).toString());
                    attributes1.setSizeSumber(row.getCell(Constants.DATA_SIZE_SUMBER_PROD) == null ? "" : row.getCell(Constants.DATA_SIZE_SUMBER_PROD).toString());
                    //Target
                    attributes1.setNamaTarget(row.getCell(Constants.ATTR_TARGET_PUB) == null ? "" : row.getCell(Constants.ATTR_TARGET_PUB).toString().toUpperCase());
                    attributes1.setDataTypeTarget(row.getCell(Constants.DATA_TYPE_TARGET_PUB) == null ? "" : row.getCell(Constants.DATA_TYPE_TARGET_PUB).toString());
                    attributes1.setSizeTarget(row.getCell(Constants.DATA_SIZE_TARGET_PUB) == null ? "" : row.getCell(Constants.DATA_SIZE_TARGET_PUB).toString());
//                    attributes1.setIsDomain(Boolean.getBoolean(row.getCell(Constants.IS_DOMAIN) == null ? "FALSE" : row.getCell(Constants.IS_DOMAIN).toString()));

                    if (checkUnsurAlreadyAded(mappings, key)) {
                        mapping = mappings.get(key);
                        mappings.remove(key);
                        if (mapping.getAttributes() != null) {
                            attributes = mapping.getAttributes();
                        }
                        attributes.put(attributes1.getNamaSumber(), attributes1);
                        mapping.setAttributes(attributes);
                        mappings.put(key, mapping);
                    } else {
                        if (mapping.getAttributes() != null) {
                            attributes = mapping.getAttributes();
                        }
                        attributes.put(attributes1.getNamaSumber(), attributes1);
                        mapping.setAttributes(attributes);
                        mappings.put(key, mapping);
                    }
                }
                mappings.put(key, mapping);
            }
        }
        wb.cloneSheet(0);
        return mappings;

    }

    public static boolean checkAttributeAlreadyAded(HashMap<String, Attributes> attributes, String key) {
        return attributes.containsKey(key);
    }

    public static Attributes getAttributeFromHashMap(HashMap<String, Attributes> attributes, String key) {
        return attributes.get(key);
    }

    public static boolean checkUnsurAlreadyAded(HashMap<String, Mapping> unsurs, String key) {
        return unsurs.containsKey(key);
    }

    public static Mapping getUnsurFromHashMap(HashMap<String, Mapping> unsurs, String key) {
        return unsurs.get(key);
    }

    public static boolean checkAlreadyAded(HashMap<String, Produk> produks, String key) {
        return produks.containsKey(key);
    }

    public static boolean checkProjectAlreadyAded(HashMap<String, Project> projects, String key) {
        return projects.containsKey(key);
    }

    public static Produk getProdukFromHashMap(HashMap<String, Produk> produks, String key) {
        return produks.get(key);
    }

    public static Project getPeojectFromHashMap(HashMap<String, Project> projects, String key) {
        return projects.get(key);
    }
}
