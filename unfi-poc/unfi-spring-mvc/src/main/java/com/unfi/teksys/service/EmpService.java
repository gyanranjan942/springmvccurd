//package com.unfi.teksys.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.unfi.teksys.beans.Emp;
//import com.unfi.teksys.dao.EmpDao;
//
//@Service
//public class EmpService {
//
//	 @Autowired
//	 EmpDao dao;//will inject dao
//
//	 public int save(Emp p){
//	   return dao.save(p);
//	 }
//	 public int update(Emp p){
//		 return dao.update(p);
//	 }
//	 public int delete(int id){
//		 return dao.delete(id);
//	 }
//	 public Emp getEmpById(int id)
//	 {
//		 return dao.getEmpById(id);
//	 }
//
//	 public List<Emp> getEmployees()
//	 {
//		 return dao.getEmployees();
//	 }
//
//}
