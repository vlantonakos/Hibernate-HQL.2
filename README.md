# Hibernate-HQL.2
int b = 60;
        Query q = session.createQuery("select rollno,name,marks from Student where marks>:b");
        q.setParameter("b", b);
        List<Object[]> students = (List<Object[]>)q.list();
        
        for(Object[] student : students) {
        	System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
        }
