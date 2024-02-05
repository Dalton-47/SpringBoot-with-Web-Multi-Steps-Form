package com.example.SpringbootWeb.implementation;

import com.example.SpringbootWeb.config.service.StudentService;
import com.example.SpringbootWeb.entity.Students;
import com.example.SpringbootWeb.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;



@Service
@Slf4j
public class StudentsImplementation implements StudentService {
  public  boolean allRecordsSaved = false;
    private final StudentRepository studentRepository;

    public StudentsImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends Students> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Students> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Students> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Students getOne(Long aLong) {
        return null;
    }

    @Override
    public Students getById(Long aLong) {
        return null;
    }

    @Override
    public Students getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Students> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Students> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Students> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Students> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Students> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Students> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Students, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Students> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Students> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Students> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Students> findAll() {
        return null;
    }

    @Override
    public List<Students> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Students entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Students> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Students> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Students> findAll(Pageable pageable) {
        return null;
    }

    //implementation of excel reading
    @Transactional(rollbackOn = Exception.class)
    public void processExcelFile(Model model, MultipartFile file) throws IOException {
        List<Students> students = new ArrayList<>();
        int rowCount = 0;
      //  boolean allRecordsSaved = false;


        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0); // when the data is in the first sheet

            Iterator<Row> rowIterator = sheet.iterator();
//            List<Students> students = new ArrayList<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) continue; // Skip header row

                Students student = new Students();
                student.setFirstName(row.getCell(1).getStringCellValue());
                student.setSecondName(row.getCell(2).getStringCellValue());
                student.setCourse(row.getCell(3).getStringCellValue());
                student.setFee(row.getCell(4).getNumericCellValue());

                students.add(student);
                rowCount++;
            }

            studentRepository.saveAll(students);
            allRecordsSaved = true;
            workbook.close();
        }
        catch (Exception e)
        {
            // Log the exception or handle it as required
            throw new RuntimeException("Error processing Excel file", e);
        }
        String message = "Successfully inserted " + rowCount + " rows.";

      //  String jsScript = "<script>document.getElementById('notification').innerHTML = '" + message + "'</script>";
        model.addAttribute("message", message);
        model.addAttribute("allRecordsSaved", allRecordsSaved);
        log.info("UPLOAD STATUS: {}", ResponseEntity.status(HttpStatus.OK).body(message));

      //  return ResponseEntity.status(HttpStatus.OK).body(message);

    }




}
