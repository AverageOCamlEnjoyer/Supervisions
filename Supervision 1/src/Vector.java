
public class Vector {
	public static int[] vectorAdd(int x,int y,int dx, int dy) {
		x=x+dx;
		y=y+dy;
		int[] result = new int[] {x,y};
		return result;
	}
	public static void main(String[] args) {
		int a=0;
		int b=2;
		int[] newVector = vectorAdd(a,b,1,1);
		a = newVector[0];
		b = newVector[1];
		
		System.out.println(a+" "+b);
		// Now (a,b) is (1,3)
		}
}
