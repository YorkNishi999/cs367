package assign1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//interface EmployeeData {
//	public abstract void addEmployee(String e);
//}

//public class EmployeeDatabase implements EmployeeData{
public class EmployeeDatabase {
	// field variables
	// Employeeクラスを要素として持つArrayList
	private static ArrayList<Employee> edb = new ArrayList<>();
	
	// Constructor
//	public EmployeeDatabase() {	
//	}

	// methods
	public String printEmployee() {
		List<String> wi = new ArrayList<String>();
		String res = "";
		
		for ( int i = 0; i < edb.size(); ++i ) {
			System.out.println(edb.get(i).getUsername()); // getUsernameがただしい？
			res += edb.get(i).getUsername();
			res += ": ";
			wi = edb.get(i).getWishlist();
			for (int j = 0; j < wi.size(); ++j) {
				System.out.print(wi.get(j) + ",");
				res += wi.get(j) + ",";
			}
			System.out.print("\n");
			res += "\n";
		}
		
		return res;
	} // end of printEmployee
	
	
	public void addEmployee(String e) {
		// 与えられたユーザ名 e を持つ従業員をデータベースの最後に追加します。
		// もし、ユーザ名eの従業員がすでにデータベースに存在する場合は、
		// 単にリターンします。
		if (e == null) {
			throw new java.lang.IllegalArgumentException();
		}
		Employee em = new Employee(e);
		// 1. 最初から最後まで、Eの従業員を検索する
		// 2. あれば→そこでBreak
		// 3. なければ→最後にUserを追加する
		for ( int i = 0; i < edb.size(); ++i ) {
			if ( edb.get(i).getUsername().equals(e) ) {
				return;
			}
		}
		edb.add(em);
		return;
	} // end of addEmployee
	
	public void addDestination(String e, String d) {
		// データベースに登録されている従業員eのウィッシュリストに、
		// 与えられた目的地dを追加します。従業員eがデータベースにない場合は、
		// java.lang.IllegalArgumentExceptionをスローします。
		// 従業員eのウィッシュリストにdが既に登録されている場合は、そのまま戻ります。
		// local variables
		
		if (e == null || d == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		List<String> wi = new ArrayList<String>();
		
		// 1. DBからEmployeeの名前を取り出す
		// 2. それがeであるかをチェック
		// 3. Yes＞目的地を取り出す　No＞次の人へ。なければErrorをスロー
		// 4. それがdであるかをチェック
		// 5. Yes＞何もせず
		// 6. No＞最後に追加する
		
		for ( int i = 0; i < edb.size(); ++i ) {
//			System.out.println(edb.get(i).getUsername()); // getUsernameがただしい？
			if ( edb.get(i).getUsername().equals(e) ) {
				wi = edb.get(i).getWishlist();
				for (int j = 0; j < wi.size(); ++j) {
					if(wi.get(j).equals(d)) {
						// Do nothing
						return;
					}
				}
				wi.add(d);
				return;
			}
//			System.out.println(edb.get(i).getWishlist());
		}
		throw new java.lang.IllegalArgumentException();
		
	}// end of addDestination
		
	boolean containsEmployee(String e) {
		// 社員eがデータベースに登録されている場合のみ、trueを返します。
		if (e == null) {
			throw new java.lang.IllegalArgumentException();
		}
		for ( int i = 0; i < edb.size(); ++i ) {
			if ( edb.get(i).getUsername().equals(e) ) {
				System.out.println(i);
				return true;
			}
		}
		return false;
	} // end of containsEmployee
	
	boolean containsDestination(String d) {
		// 目的地dがデータベース内の少なくとも1つの社員のウィッシュリストに
		// 表示されている場合に限り、trueを返します。
		if (d == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		System.out.println("contains function 	called");
		
		List<String> wi = new ArrayList<String>();
		
		for ( int i = 0; i < edb.size(); ++i ) {
				wi = edb.get(i).getWishlist();
				for (int j = 0; j < wi.size(); ++j) {
					System.out.println("koko " + wi.get(j));
					if(wi.get(j).equals(d)) { // この書き方はオブジェクト指向特徴やな。。
						System.out.println("koko match " + wi.get(j));
						return true;
					}
				}
		}
		return false;
		
	} // end of containsDestination
		
	boolean hasDestination(String e, String d) {
		// 目的地dが従業員eのウィッシュリストに入っている場合のみ、trueを返します。
		if (e == null || d == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		List<String> wi = new ArrayList<String>();
				
		for ( int i = 0; i < edb.size(); ++i ) {
			if ( edb.get(i).getUsername().equals(e) ) {
				wi = edb.get(i).getWishlist();
				for (int j = 0; j < wi.size(); ++j) {
					if(wi.get(j).equals(d)) {
						return true;
					}
				}
				return false;
			}
		}
		return false;
	} // end of has Destination
	
	List<String> getEmployees(String d) {
		// 目的地dをウィッシュリストに入れている社員のリストを返します。
		// 目的地dがデータベースにない場合は、NULLのリストを返します。
		if (d == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		List<String> res = new ArrayList<String>();
		
		for ( int i = 0; i < edb.size(); ++i ) {
			for (int j = 0; j < edb.get(i).getWishlist().size(); ++j) {
				if(edb.get(i).getWishlist().get(j).equals(d)) {
					res.add(edb.get(i).getUsername());
				}
			}	
		}
		return res;
		
	} // end of getEmplyyees
	
	List<String> getDestinations(String e) {
		// 従業員eのウィッシュリストを返します。
		// 従業員eがデータベースに存在しない場合は、nullを返します。
		if (e == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		List<String> res = new ArrayList<String>();
		
		for ( int i = 0; i < edb.size(); ++i ) {
			if ( edb.get(i).getUsername().equals(e) ) {
				res = edb.get(i).getWishlist();
			}
		}
		if (res != null) {
			return res;
		} else {
			return null;
		}
		
	} // end of getDestinations
	
	Iterator<Employee> iterator(){
		// データベース内の Employee オブジェクトの Iterator を返します。
		// 従業員は、データベースに追加された順 (テキスト・ファイルに含まれる順) 
		// で返される必要があります。
		
		Iterator<Employee> ei = edb.iterator();
		return ei;
		
	} // end of iterator
	
	boolean removeEmployee(String e) {
		// データベースから従業員eを削除します。従業員eがデータベースに存
		// しない場合は、falseを返し、そうでない場合（つまり、削除が成功した
		// 場合）は、trueを返します。
		Iterator<Employee> item = edb.iterator();
		
		if (e == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		System.out.println(iterator().next());
		
		while ( item.hasNext()) {
			if ( item.next().getUsername().equals(e)) {
				System.out.println("iterator work");
				item.remove();
				return true;
			}
		}
		return false;
	} // end of removeEmployee

	boolean removeDestination(String d) {
		// データベースから目的地dを削除する、つまり、目的地dが登場するすべての
		// ウィッシュリストから目的地dを削除する。目的地dがデータベースに存在しな
		// い場合はfalseを、そうでない場合（つまり削除が成功した場合）はtrueを返
		// します。
		
		int count = 0; 
		
		if (d == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		for ( int i = 0; i < edb.size(); ++i ) {
			for (int j = 0; j < edb.get(i).getWishlist().size(); ++j) {
				if(edb.get(i).getWishlist().get(j).equals(d)) {
					String a = edb.get(i).getWishlist().get(j);
					System.out.println(a);
					edb.get(i).getWishlist().remove(d);
					++count;
				}
			}	
		}
		if (count > 0)
			return true;
		else
			return false;
		
	} // end of removeDestination
	
	int size() {
		int counter = 0;
		
		while (edb.iterator().hasNext()) {
			++counter;
		}
		return counter;
	} // end of size
	
	

} // end of class