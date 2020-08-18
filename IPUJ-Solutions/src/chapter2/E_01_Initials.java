package chapter2;

public class E_01_Initials {
	public static void main(String[] args) {
		//Whitespace variables
		String n = " ", n2 = "  ", n3 = "   ", n4 = "    ", n5 = "     ";
		System.out.println("My initials: J D G C\n");
		//Bunch of *'s variables
		String a2 = "**", a4="****", a6="******"; 
		//Other symbols
		String b = "|";
		//Letters that are nine lines tall
		//----------------------      J               -          D       -        G       -       C      ------
		System.out.println(b+n3+ a4+a4+a4+   a4+    '\t'+a6+n3+     n3+'\t'+n+a6+a4 + n+'\t'+n+a6+a4 + n+ n3+b);
		System.out.println(b+n3+ n4+n3+a2+   n5+n2+ '\t'+a2+n4+a2+  n4+'\t'+a2+n4+n4+a2+'\t'+a2+n4+n4+a2+ n3+b);
		System.out.println(b+n3+ n4+n3+a2+   n5+n2+ '\t'+a2+n5+a2+  n3+'\t'+a2+n5   +n5+'\t'+a2+n4+n4+a2+ n3+b);
		System.out.println(b+n3+ n4+n3+a2+   n5+n2+ '\t'+a2+n5+n+a2+n2+'\t'+a2+n5   +n5+'\t'+a2+n5+   n5+ n3+b);
		System.out.println(b+n3+ n4+n3+a2+   n5+n2+ '\t'+a2+n5+n+a2+n2+'\t'+a2+n3+a6+ n+'\t'+a2+n5+   n5+ n3+b);
		System.out.println(b+n3+ a2+n5+a2+   n5+n2+ '\t'+a2+n5+n+a2+n2+'\t'+a2+n4+n4+a2+'\t'+a2+n5+   n5+ n3+b);
		System.out.println(b+n3+ n+a2+n4+a2+ n5+n2+ '\t'+a2+n5+a2+  n3+'\t'+a2+n4+n4+a2+'\t'+a2+n4+n4+a2+ n3+b);
		System.out.println(b+n3+ n2+a2+n2+a2+ n5+n3+'\t'+a2+n4+a2+  n4+'\t'+a2+n4+n4+a2+'\t'+a2+n4+n4+a2+ n3+b);
		System.out.println(b+n3+ n3+a4      +n5+n4+ '\t'+a6+n3+     n3+'\t'+n+a6+a4 + n+'\t'+n+a6+a4 + n+ n3+b);
	}
}
