public class Tree {
	String string;
	Tree firstChild;
	Tree nextSibling;

	public Tree(String string, Tree firstChild, Tree nextSibling) {
		this.string = string;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}
	public Tree(String string, Tree nextSibling) {
		this.string = string;
		this.firstChild = null;
		this.nextSibling = nextSibling;
	}
	public Tree(String string) {
		this.string = string;
		this.firstChild = null;
		this.nextSibling = null;
	}

	public void listAll() {
		listAll(0);
	}

	private void listAll(int depth) {
		for(int i = 0; i < depth; i++) {
			System.out.print("\t");
		}
		System.out.println(this.string);
		if( this.string.charAt(this.string.length()-1) == '*') {
			Tree nextSiblingPointer = this.firstChild;
			while(nextSiblingPointer != null) {
				nextSiblingPointer.listAll(depth + 1);
				nextSiblingPointer = nextSiblingPointer.nextSibling;
			}
		}
	}

	public static void main(String[] args) {
		Tree root = new Tree("/usr*", new Tree("mark*", new Tree("book*", new Tree("course*", new Tree("junk"))), new Tree("alex*", new Tree("junk"), new Tree("bill*", new Tree("work*", new Tree("course*")), null))), null );

		root.listAll();
	}
}