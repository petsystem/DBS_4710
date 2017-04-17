/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsystem;

/**
 *
 * @author xumc
 */
public class DeleteReport {
    private int report_id;
    private String report_date;
    private String status_flag;
    private String pet_type;
    private String pet_name;
    private String pet_breed;
    
public DeleteReport(int reportid, String reportdate,String statusflag,String pettype,String petname,String petbreed)
{
    this.report_id=reportid;
    this.report_date=reportdate;
    this.status_flag=statusflag;
    this.pet_type=pettype;
    this.pet_name=petname;
    this.pet_breed=petbreed;
    
}

       public int getreportid()
       {
       return report_id;
       }
       
       public String getreportdate()
       {
       return report_date;
       }
       
       public String getstatusflag()
       {
       return status_flag;
       }
       public String getpettype()
       {
       return pet_type;
       }
       public String getpetname()
       {
       return pet_name;
       }
       public String getpetbreed()
       {
       return pet_breed;
       }
        
    
}
