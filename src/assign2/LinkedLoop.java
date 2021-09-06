package assign2;

import java.util.Iterator;

import assign1.Employee;

// LoopADTから作られたクラスで、←のインターフェースを実装する
//　Imageクラスをいっぱい色々いじる感じで。
//　保存する先は、Doublelist（双方向リスト）

public class LinkedLoop<T> implements LoopADT<Image> {
	

	@Override
	public void add(Image item) {
		// TODO Auto-generated method stub
		// 入ってきた画像ファイルを、LoopADTに対してAddする
		// image classのオブジェクトをなんらかがちゃがちゃ操作すればよい

		DblListnode dlist = new DblListnode(item);
		
		

	}

	@Override
	public Image getCurrent() throws EmptyLoopException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image removeCurrent() throws EmptyLoopException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Image> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
