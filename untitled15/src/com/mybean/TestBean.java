package com.mybean;
import javax.swing.text.View;
import java.io.*;
import java.io.FileNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commoms.logging.LogFactory;
public class TestBean extends BaseBean implements Serializable{
    public String desc;
    public static final int serialVersionUID=1;
    public TestBean(String id){
        super(id);
    }
   public String toString(){
        return "TestBean{"+"desc='"+desc+'\''+",property1='"+property1+'\''+",property2='"+property2+'\''+",property3="+property3+'}';
   }
   private void writeObject(java.io.ObjectOutputStream out)
       throws IOException{
        out.defaultWriteObject();
        out.writeUTF(property1);
        out.writeUTF(property2);
        out.writeInt(property3);
   }
   private void readObject(java.io.ObjectInputStream in)
           throws IOException, ClassCastException, ClassNotFoundException {
        in.defaultReadObject();
        property1=in.readUTF();
        property2=in.readUTF();
        property3=in.readInt();
   }
   public void serialization(View view){
        try{
            TestBean testBean=new TestBean("");
            testBean.property1="属性1234";
            testBean.property2="属性458";
            testBean.desc="我是靳悦悦";
            testBean.property3=7423465;

            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(""));
            objectOutputStream.writeObject(testBean);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   public void deserialization(View view){
        ObjectInputStream objectInputStream=null;
        try{
            objectInputStream=new ObjectInputStream(new FileInputStream(""));
            TestBean testBean=(TestBean)
                    objectInputStream.readObject();
            Log.i(TAG,"deserialization"+testBean.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
   }
}

