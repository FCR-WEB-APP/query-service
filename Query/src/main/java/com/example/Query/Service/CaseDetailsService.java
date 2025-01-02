package com.example.Query.Service;

import com.example.Query.Dao.CaseDetailsDao;
import com.example.Query.Dto.Search;
import com.example.Query.Entity.CaseDetails;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CaseDetailsService {

    private final CaseDetailsDao caseDetailsDao;

    public CaseDetailsService(CaseDetailsDao caseDetailsDao) {
        this.caseDetailsDao = caseDetailsDao;
    }

    public Map<String, Object> getCaseDetails(String activityLevel) {
        List<CaseDetails> res = caseDetailsDao.getCaseDetails(activityLevel);
        return Map.of(
                "status" , HttpStatus.OK.value(),
                "success" , "successfully fetched",
                "data",res
        );
    }

    public Map<String, Object> search(Search search) {
    List<Search> res = caseDetailsDao.search(search);
        return Map.of(
                "status" , HttpStatus.OK.value(),
                "success" , "successfully searched",
                "data",res
        );

    }
    public byte[] createExcelFile(Map<String, Object> res) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Case Details Search");

            // Create the header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Case Ref No");
            headerRow.createCell(1).setCellValue("Group Name");
            headerRow.createCell(2).setCellValue("Division Name");
            headerRow.createCell(3).setCellValue("Activity Level");
            headerRow.createCell(4).setCellValue("Status");
            headerRow.createCell(5).setCellValue("Assigned To");
            headerRow.createCell(6).setCellValue("Created Date");
            headerRow.createCell(7).setCellValue("Updated Date");
            headerRow.createCell(8).setCellValue("Planning");
            headerRow.createCell(9).setCellValue("Field Work");

            List<Search> searchList = (List<Search>) res.get("data");

            int rowNum = 1;
            for (Search search : searchList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(search.getCaseRefNo());
                row.createCell(1).setCellValue(search.getGroupName());
                row.createCell(2).setCellValue(search.getDivisionName());
                row.createCell(3).setCellValue(search.getActivityLevel());
                row.createCell(4).setCellValue(search.getStatus());
                row.createCell(5).setCellValue(search.getAssignedTo());
                row.createCell(6).setCellValue(search.getCreatedDate().toString());
                row.createCell(7).setCellValue(search.getUpdatedDate().toString());
                row.createCell(8).setCellValue(search.getPlaning());
                row.createCell(9).setCellValue(search.getFieldWork());
            }

            // Write the Excel file to a byte array output stream
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                workbook.write(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate Excel file", e);
        }
    }


//    public Map<String, Object> search(Long caseRefNo, String groupName, String divisionName, String activityLevel, String status, String assignedTo, LocalDateTime createdDate, LocalDateTime updatedDate, String planing, String fieldWork) {
//        CaseDetails caseDe    tails = caseDetailsDao.search(caseRefNo,groupName,divisionName,activityLevel,status,assignedTo,createdDate,updatedDate,planing,fieldWork);
//        return Map.of(
//                "status" , HttpStatus.OK.value(),
//                "success" , "successfully searched",
//                "data",caseDetails
//        );
//
//    }
}
