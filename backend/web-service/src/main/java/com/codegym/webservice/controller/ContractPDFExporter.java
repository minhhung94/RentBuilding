package com.codegym.webservice.controller;

import com.codegym.dao.entity.Contract;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import com.lowagie.text.Image;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ContractPDFExporter {
    private Contract contract;

    public ContractPDFExporter(Contract contract) {
        super();
        this.contract = contract;
    }


    public void export(HttpServletResponse response) throws IOException, DocumentException {
        Document document = new Document(PageSize.A3);
        Image image = Image.getInstance(contract.getUrlImage());


        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("da", "DK"));
        String currentDateTime = dateFormatter.format(new Date());
        Font fontTitle = new Font(Font.TIMES_ROMAN, 20, Font.BOLDITALIC, Color.RED);
        Font fontProperties = new Font(Font.TIMES_ROMAN, 13, Font.BOLD, Color.BLUE);
        Font fontContent = new Font(Font.TIMES_ROMAN, 13, Font.NORMAL, Color.black);

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        document.add(new Paragraph("Chi Tiết Hợp Đồng", fontTitle));

        addEmptyLine(preface, 3);
        document.add(new Paragraph("ID hợp đồng : " + contract.getId(), fontContent));
        document.add(new Paragraph("Tên khách hàng : " + contract.getCustomer().getName(), fontContent));
        document.add(new Paragraph("Số CMND khách hàng : " + contract.getCustomer().getIdCard(), fontContent));
        document.add(new Paragraph("Địa chỉ khách hàng : " + contract.getCustomer().getAddress(), fontContent));
        document.add(new Paragraph("Ngày sinh khách hàng : " + dateFormatter.format(contract.getCustomer().getBirthday()), fontContent));
        document.add(new Paragraph("Email khách hàng : " + contract.getCustomer().getEmail(), fontContent));
        document.add(new Paragraph("Số điện thoại khách hàng : " + contract.getCustomer().getPhone(), fontContent));
        document.add(new Paragraph("Tên nhân viên : " + contract.getEmployee().getName(), fontContent));
        document.add(new Paragraph("SĐT nhân viên : " + contract.getEmployee().getPhone(), fontContent));
        document.add(new Paragraph("Email nhân viên : " + contract.getEmployee().getEmail(), fontContent));
        document.add(new Paragraph("Ngày bắt đầu thuê : " + dateFormatter.format(contract.getStartRentDay()), fontContent));
        document.add(new Paragraph("Ngày kết thúc thuê : " + dateFormatter.format(contract.getEndRentDay()), fontContent));
        document.add(new Paragraph("Mã mặt bằng thuê : " + contract.getGround().getCodeGround(), fontContent));
        document.add(new Paragraph("Loại mặt bằng thuê : " + contract.getGround().getTypeGround().getNameTypeGround(), fontContent));
        document.add(new Paragraph("Diện tích : " + numberFormat.format(contract.getGround().getArea()), fontContent));
        document.add(new Paragraph("Tổng tiền : " + numberFormat.format(contract.getTotal()), fontContent));
        document.add(new Paragraph("Tiền cọc : " + numberFormat.format(contract.getDeposits()), fontContent));
        document.add(new Paragraph("Mã số thuế : " + contract.getTaxCode(), fontContent));
        document.add(new Paragraph("Nội dung hợp đồng : " + contract.getContent(), fontContent));
        document.add(new Paragraph("Hình ảnh hợp đồng : ", fontContent));
        document.add(image);
        document.add(new Paragraph("Ngày in hợp đồng : " + currentDateTime, fontContent));


//        PdfPTable table = new PdfPTable(2);
//        table.setWidthPercentage(100);
//        document.add(table);
        document.close();

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }


}
