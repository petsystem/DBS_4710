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
    class Pet_Search {
    private String status_flag,p_type,p_name,p_breed,p_ecolor,p_bcolor,p_age,p_sex,p_mchip,p_description,u_name;
    private int u_phone;
    
    public Pet_Search(String statusflag,String type, String name, String breed, String ecolor, String bcolor, String age, String sex,String mchip, String description,String uname,int phone)
    {
        this.status_flag=statusflag;
        this.p_type=type;
        this.p_name=name;
        this.p_breed=breed;
        this.p_ecolor=ecolor;
        this.p_bcolor=bcolor;
        this.p_age=age;
        this.p_sex=sex;
        this.p_mchip=mchip;
        this.p_description=description;
        this.u_name=uname;
        this.u_phone=phone;
        
    }
    public String getstatusflag()
    {
        return status_flag;
    
    }
    
    public String gettype()
    {
        return p_type;
    }
    
     public String getname()
    {
        return p_name;
    }
     
      public String getbreed()
    {
        return p_breed;
    }
      
       public String getecolor()
    {
        return p_ecolor;
    }
       
        public String getbcolor()
    {
        return p_bcolor;
    }
         public String getage()
    {
        return p_age;
    }
          public String getsex()
    {
        return p_sex;
    }
           public String getmchip()
    {
        return p_mchip;
    }
            public String getdescription()
    {
        return p_description;
    }
            public String getuname()
    {
        return u_name;
    }
     
            public int getphone()
    {
        return u_phone;
    }
     
}
