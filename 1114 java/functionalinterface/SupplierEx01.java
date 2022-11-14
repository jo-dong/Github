package functionalinterface;

import java.util.function.Supplier;

public class SupplierEx01 {

	public static void main(String[] args) {

		// Supplier<T> ===========================================
		// get() : parameter (X), return (O)
		// Lambda : () -> T
		// =======================================================
		
		Supplier<String> supplier = () -> "Functional Interface";
		System.out.println(supplier.get());
		
	}

}
