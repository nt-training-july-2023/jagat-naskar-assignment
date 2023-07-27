package OppsConcept;

public class HierarchicalInheritance {

	public static void main(String[] args) {
		System.out.println("       --HierarchicalInheritance--");
		System.out.println("       ___________________________\n\n\n");
		System.out.println("Calling from AllamandaTree");
		System.out.println("---------------------------");
		AllamandaTree allamandaTree = new AllamandaTree();
		allamandaTree.colorOfLeaves();
		allamandaTree.colorOfMyLeaves();
		
		System.out.println("\n\nCalling from BlueSpruceTree");
		System.out.println("--------------------------------");
		BlueSpruceTree blueSpruceTree = new BlueSpruceTree();
		blueSpruceTree.LeavesColor();
		blueSpruceTree.colorOfLeaves();
	}
}

class Tree{
	public void colorOfLeaves()
	{
		System.out.println("All most all trees are green.");
	}
	
}
class AllamandaTree extends Tree{
	public void colorOfMyLeaves()
	{
		System.out.println("Hi, I am AllamandaTree, The color of my leaves are yellow in color");;
	}
}

class  BlueSpruceTree extends Tree{
	public void LeavesColor() {
		System.out.println("Hi, I am blueSpruceTree, My leaves are blue in color");
	}
}
