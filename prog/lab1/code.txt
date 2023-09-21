public class Main {
	public static void main(String args[]) {
		
		short[] c = {
			5,7,9,11,13,15,17
		};
		
		float[] x = new float[12];
					
		for (int i = 0; i < x.length; i++) {
			x[i] = ((float)Math.random() * 9.0F) -2.0F; 
			//math.random() возвращает знач. [0.0F, 1.0F]
			//чтобы заполнить значения -2 до 7, умножаем на 9 и вычитаем два
		}
		
		float[][] array = new float[7][12];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = x.clone();
		}
		
		
		for (int i = 0; i < c.length; i++)	{
			for (int j = 0; j < x.length; j++) {
				
				float _x = c[i];
				
				if (c[i] == 9) {	
					array[i][j] = (float)Math.pow(
						( 
							Math.asin(Math.exp(-Math.abs(_x)))
						) * 
						(
							(
								((_x / 3.0F) + 4.0F) / 
								(Math.log(Math.abs(_x)))
							) 
							- 1.0F
						), 2);
				}
				
				else if (containsArray(c, new short[] {5,7,17})) {
					array[i][j] = (float)Math.pow((
						Math.exp(
							Math.pow((
								_x
							), 1.0F / 3.0F)
						)
					), 1.0F / 3.0F);
				}
				else {
					array[i][j] = (float)Math.log(
						Math.acos(
							Math.pow(
							(
								1.0F / (Math.exp(Math.abs(_x)))
							),2)
						)
					);
				}
			}
		}
		
		System.out.println("[");
		for (int i = 0; i < c.length; i++) {
			
			String row = "    [" + String.format("%.5f", array[i][0]).replace(",", ".");
			for (int j = 1; j < x.length; j++) {
				row += ", " + String.format("%.5f", array[i][j]).replace(",", ".");
			}
			
			if (i != c.length - 1) {
				System.out.println(row + "],");
			}
			else {
				System.out.println(row + "]");
			}
		}
		
		System.out.println("]");
	}
	
	public static boolean containsArray(short[] array, short[] nums) 
	{
		for (int i = 0; i < nums.length; i++) {
			if (!containsElement(array, nums[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean containsElement(short[] array, short element) 
	{		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return true;
			}
		}
		
		return false;
	}		
}