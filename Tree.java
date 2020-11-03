public class Tree {
	String string;
	Tree firstChild;
	Tree nextSibling;
	int size;

	public Tree(String string, Tree firstChild, Tree nextSibling) {
		this.string = string;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
		this.size = string.charAt(string.length()-1) == '*' ? 1 : 10;
	}
	public Tree(String string, Tree nextSibling) {
		this(string, (Tree)null, nextSibling);

	}
	public Tree(String string) {
		this(string, (Tree)null, (Tree)null);
	}

	public void listAll() {
		listAll(0);
	}
	//preorder traversal: name is printed before processing children
	private void listAll(int depth) {
		for(int i = 0; i < depth; i++) {
			System.out.print("\t");
		}
		System.out.println(this.string+ "(" + this.size + ")");

		if( this.string.charAt(this.string.length()-1) == '*') {
			Tree nextSiblingPointer = this.firstChild;
			while(nextSiblingPointer != null) {
				nextSiblingPointer.listAll(depth + 1);
				nextSiblingPointer = nextSiblingPointer.nextSibling;
			}
		}
	}
	//postorder traversal: size is calculated after children are processed
	public int size() {
		int totalSize = this.size;
		if( this.string.charAt(this.string.length()-1) == '*') {
			Tree nextSiblingPointer = this.firstChild;
			while(nextSiblingPointer != null) {
				totalSize += nextSiblingPointer.size();
				nextSiblingPointer = nextSiblingPointer.nextSibling;
			}
		}
		return totalSize;
	}

	public static void main(String[] args) {
		Tree root = new Tree("/usr*", new Tree("mark*", new Tree("book*", new Tree("course*", new Tree("junk"))), new Tree("alex*", new Tree("junk"), new Tree("bill*", new Tree("work*", new Tree("course*")), null))), null );

		root.listAll();

		System.out.println("\nThe total size of the tree is " + root.size());
	}
}
