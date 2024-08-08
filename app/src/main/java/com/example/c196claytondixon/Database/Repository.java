package com.example.c196claytondixon.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.c196claytondixon.DAO.AssessmentDAO;
import com.example.c196claytondixon.DAO.CourseDAO;
import com.example.c196claytondixon.DAO.TermDAO;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.Entity.TermEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private TermDAO mTermDAO;
    private CourseDAO mCourseDAO;
    private AssessmentDAO mAssessmentDAO;
    private List<TermEntity> mAllTerms;
    private List<CourseEntity> mAllCourses;
    private List<AssessmentEntity> mAllAssessments;
    private TermEntity mTermEntity;
    private CourseEntity mCourseEntity;
    private AssessmentEntity mAssessmentEntity;
    private int count;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        DatabaseBuilder db=DatabaseBuilder.getDatabase(application);
        mTermDAO=db.termDAO();
        mCourseDAO=db.courseDAO();
        mAssessmentDAO=db.assessmentDAO();
    }

        // TERM SECTION

    public TermEntity getTermByID(int termID) {
        databaseExecutor.execute(() ->{
           mTermEntity = mTermDAO.getTermByID(termID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mTermEntity;
    }

    public List<TermEntity> getAllTerms() {
        databaseExecutor.execute(() ->{
           mAllTerms = mTermDAO.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllTerms;
    }

    public int getTermCount() {
        databaseExecutor.execute(() ->{
          count = mTermDAO.getTermCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public void insertTerm(TermEntity termEntity) {
        databaseExecutor.execute(() ->{
            mTermDAO.insertTerm(termEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void insertAllTerms(List<TermEntity> termEntity) {
        databaseExecutor.execute(() ->{
            mTermDAO.insertAllTerms(termEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void updateTerm(TermEntity termEntity) {
        databaseExecutor.execute(() ->{
            mTermDAO.updateTerm(termEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteTerm(TermEntity termEntity) {
        databaseExecutor.execute(() ->{
            mTermDAO.deleteTerm(termEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteAllTerms() {
        databaseExecutor.execute(() ->{
            mTermDAO.deleteAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

        //COURSE SECTION

    public List<CourseEntity> getAllCourses() {
        databaseExecutor.execute(() ->{
           mAllCourses = mCourseDAO.getAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllCourses;
    }

    public List<CourseEntity> getCoursesByTerm(int termID) {
        databaseExecutor.execute(() ->{
            mAllCourses = mCourseDAO.getCoursesByTerm(termID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllCourses;
    }



    public CourseEntity getCourseByID(int courseID) {
        databaseExecutor.execute(() ->{
           mCourseEntity = mCourseDAO.getCourseByID(courseID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mCourseEntity;
    }

    public int getCourseCount() {
        databaseExecutor.execute(() ->{
           count = mCourseDAO.getCourseCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public int getCountByTerm(int termID) {
        databaseExecutor.execute(() ->{
            count = mCourseDAO.getCountByTerm(termID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public void insertCourse(CourseEntity courseEntity) {
        databaseExecutor.execute(() ->{
            mCourseDAO.insertCourse(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void insertAllCourses(List<CourseEntity> courseEntity) {
        databaseExecutor.execute(() ->{
            mCourseDAO.insertAllCourses(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void updateCourse(CourseEntity courseEntity) {
        databaseExecutor.execute(() ->{
            mCourseDAO.updateCourse(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteCourse(CourseEntity courseEntity) {
        databaseExecutor.execute(() ->{
            mCourseDAO.deleteCourse(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteAllCourses() {
        databaseExecutor.execute(() ->{
            mCourseDAO.deleteAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //ASSESSMENT SECTION

    public List<AssessmentEntity> getAllAssessments() {
        databaseExecutor.execute(() ->{
           mAllAssessments = mAssessmentDAO.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public AssessmentEntity getAssessmentByID(int assessmentID) {
        databaseExecutor.execute(() ->{
            mAssessmentEntity = mAssessmentDAO.getAssessmentByID(assessmentID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAssessmentEntity;
    }

    public List<AssessmentEntity> getAssessmentByCourse(int courseID) {
        databaseExecutor.execute(() ->{
            mAllAssessments = mAssessmentDAO.getAssessmentByCourse(courseID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public void insertAssessment(AssessmentEntity assessmentEntity) {
        databaseExecutor.execute(() ->{
            mAssessmentDAO.insertAssessment(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void insertAllAssessments(List<AssessmentEntity> assessmentEntity) {
        databaseExecutor.execute(() ->{
            mAssessmentDAO.insertAllAssessments(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void updateAssessment(AssessmentEntity assessmentEntity) {
        databaseExecutor.execute(() ->{
            mAssessmentDAO.updateAssessment(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteAssessment(AssessmentEntity assessmentEntity) {
        databaseExecutor.execute(() ->{
            mAssessmentDAO.deleteAssessment(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deleteAllAssessments() {
        databaseExecutor.execute(() ->{
            mAssessmentDAO.deleteAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public int getAssessmentCount() {
        databaseExecutor.execute(() ->{
           count = mAssessmentDAO.getAssessmentCount();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public int getAssessmentCountByCourse(int courseID) {
        databaseExecutor.execute(() ->{
            count = mAssessmentDAO.getAssessmentCountByCourse(courseID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public int getAssessmentCountByAnyCourse() {
        databaseExecutor.execute(() ->{
            count = mAssessmentDAO.getAssessmentCountByAnyCourse();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }



}
