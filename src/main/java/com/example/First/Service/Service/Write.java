package com.example.First.Service.Service;

/*
import com.example.First.ClassEntity.Documents;
import com.example.First.repo.DocumentsRepo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class Write {
    private XWPFDocument doс;
    @Autowired
    private DocumentsRepo documentsRepo;

    public void setDoс(long id) throws SQLException, InvalidFormatException, IOException {
        List<Documents> documents = (List<Documents>) documentsRepo.findAll();
        Documents doa = documents.get(0);
        InputStream i = doa.getBlob().getBinaryStream();
        byte[] b = doa.getBlob().getBytes(1, (int) doa.getBlob().length());
        File file = new File("tmp.docx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(b);
        fileOutputStream.close();
        this.doс = new XWPFDocument(OPCPackage.open("tmp.docx"));

    }

    public Write() throws IOException, InvalidFormatException {
    }


    public void replace(HashMap<String, String> reportText) throws IOException {
        for (String key : reportText.keySet()) {
            for (XWPFParagraph paragraph : this.doс.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String txt = run.getText(0);
                    if (txt != null) {
                        if (txt.contains(key)) {
                            txt =txt.replace(key, reportText.get(key));
                            run.setText(txt,0);
                        }
                    }
                }
            }
        }
        doс.write(new FileOutputStream(new File("result.docx")));
        doс.close();
    }
}



*/
