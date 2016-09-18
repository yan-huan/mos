import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.scheduling.config.Task;

import com.myb.entity.pojo.mos.Employee;


public class TestUtils {
	

	
	public static void main(String[] args) {
		
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
//		for (int i = 0; i < max; i++) {
//		    UUID uuid = UUID.randomUUID();
//		    values.add(uuid.toString());
//		}

//		然后我们计算一下排序这个Stream要耗时多久，
//		串行排序：
//		复制代码 代码如下:

/*		long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));*/
		// 串行耗时: 899 ms
//		并行排序：
//		复制代码 代码如下:

		/*long t0 = System.nanoTime();
		long count = values.parallelStream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));*/
		
		
		
		
//		List<String> stringCollection = new ArrayList<>();
//		stringCollection.add("ddd2");
//		stringCollection.add("aaa2");
//		stringCollection.add("bbb1");
//		stringCollection.add("aaa1");
//		stringCollection.add("bbb3");
//		stringCollection.add("ccc");
//		stringCollection.add("bbb2");
//		stringCollection.add("ddd1");
//		
//		long t0 = System.nanoTime();
//		stringCollection
//	    .stream()
//	    .filter((s) -> s.startsWith("a"))
//	    .forEach(System.out::println);
//		long t1 = System.nanoTime();
//		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("sequential sort took: %d ms", millis));
//	// "aaa2", "aaa1"
//		
//		long t2 = System.nanoTime();
//		for (String sc : stringCollection) {
//			
//			if (sc.startsWith("a")) {
//				System.out.println(sc);
//			}
//		}
//		long t3 = System.nanoTime();
//		
//		long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
//		System.out.println(String.format("sequential sort took: %d ms", millis1));

		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee = new Employee();
		employee.setCityId(2);
		employees.add(employee);
		List<Employee> aa = Arrays.asList(employee);
		List<String> names = Arrays.asList("111","222","333");
		//排序倒序
		Collections.sort(names, (a,b) -> b.concat("ccc").compareTo(a));
		
//		employees.parallelStream().filter(predicate);
		
		employees.forEach(e -> {
			if (e.getCityId()==2) {
				e.setCityId(3);
			}
//			System.out.println(e.getCityId());
		});
		System.out.println(employees.get(0).getCityId());
//		Arrays.asList(employees).forEach(e -> System.out.println(e););
		
//		final Employee employee2 = Employee.Employee(Employee::new);
	
		
		
		
		final Clock clock = Clock.systemUTC();
		// Get the local date and local time
		final LocalDate date = LocalDate.parse("2016-06-11");
		final LocalDate dateFromClock = LocalDate.now( clock );
		        
		System.out.println( date );
		System.out.println( dateFromClock );
		        
		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );
		        
		System.out.println( time );
		System.out.println( timeFromClock );
//		System.out.println( result );
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		        
		System.out.println( engine.getClass().getName() );
		try {
			System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
		} catch (ScriptException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		  final String text = "Base64 finally in Java 8!";
	        
	        final String encoded = Base64
	            .getEncoder()
	            .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
	        System.out.println( encoded );
	        
	        final String decoded = new String( 
	            Base64.getDecoder().decode( encoded ),
	            StandardCharsets.UTF_8 );
	        System.out.println( decoded );
		
		
	        
	        
	        long[] arrayOfLong = new long [ 200000 ];        
	        
	        Arrays.parallelSetAll( arrayOfLong, 
	            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
	        Arrays.stream( arrayOfLong ).limit( 100).forEach( 
	            i -> System.out.print( i + " " ) );
	        System.out.println();
	        
	        Arrays.parallelSort( arrayOfLong );     
	        Arrays.stream( arrayOfLong ).limit( 100).forEach( 
	            i -> System.out.print( i + " " ) );
	        
	        
	        
//	        Arrays.parallelSort(employees, (a,b)->b.);
	}
}
