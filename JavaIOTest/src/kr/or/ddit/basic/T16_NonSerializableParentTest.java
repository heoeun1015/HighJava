package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

	/*	<< 부모 클래스가 Serializable 인터페이스를 구현하고 있지 않은 경우 부모 객체의 필드값 처리 방법 >>
	 	
	 	1. 부모 클래스가 Serializable 인터페이스를 구현하도록 해야 한다.
	 	2. 자식 클래스에 writeObject()와 readObject()메서드를 이용하여 부모 객체의 필드값을 처리할 수 있도록 직접 구현한다.	 */

public class T16_NonSerializableParentTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/nonSerialTest.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Child child = new Child();
		child.setParentName("부모");
//		child.setAge(14);
//		child.setAddr("대전");
		child.setChildName("자식");
		oos.writeObject(child);		// 직렬화
		oos.flush();		// 생략가능
		oos.close();
		
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
		
		FileInputStream fis = new FileInputStream("d:/D_Other/nonSerialTest.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Child child2 = (Child)ois.readObject();		// 역직렬화. 구현되어 있는지 확인
		System.out.println("parentName: " + child2.getParentName());
//		System.out.println("parentAge: " + child2.getAge());
//		System.out.println("parentAddr: " + child2.getAddr());
		System.out.println("childName: " + child2.getChildName());
		
		ois.close();
		fis.close();
		
	}
}



// Serializable을 구현하지 않은 부모 클래스
//class Parent implements Serializable{		// 여기서 구현을 하면 자식 클래스도 Serializable을 구현하게 된다.
class Parent{
	private String parentName;
//	private int age;
//	private String addr;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getAddr() {
//		return addr;
//	}
//
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
	
	
	
}

// Serializable을 구현한 자식 클래스
class Child extends Parent implements Serializable {
	
	private static final long serialVersionUID = -686783374427953199L;
	
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
	
	// 직렬화 될 때 자동으로 호출됨.
	private void writeObject(ObjectOutputStream out) throws IOException{
		// ObjectOutputStream 객체의 메서드를 이용하여 부모 객체 필드값 처리
		out.writeUTF(getParentName());		// 이 부분이 있어야 함. write 할 수 있도록. 그래야 아래가 시행이 된다.
//		out.writeInt(getAge());
//		out.writeUTF(getAddr());
		out.defaultWriteObject();
	}
	
	// 역직렬화 될 때 자동으로 호출 됨
	// (접근 제한자가 private이 아니면 자동호출 되지 않음.)
	// public으로 하면 안 한 것과 마찬가지
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		// ObjectInputStream 객체의 메서드를 이용하여 부모 객체 필드값 처리
		setParentName(in.readUTF());
//		setAge(in.readInt());
//		setAddr(in.readUTF());
		in.defaultReadObject();
	}
	
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/	
	
	// 위 두 구문을 주석처리 하면 parentName이 Null이 나온다. 직렬화 대상에서 제외됐기 때문.
	// parentName가 나오게 하기 위해서는 위 구문을 써주어야 한다.
	
}


