import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.TestTimedOutException;

public class CharCollectionTest {

	static CharCollection bananen, apfelstrudel, xyyzz, momentum, test, hochschule, aaaaaa, abrakadabra, wald, leer;

	@BeforeClass
	public static void setUp() {

		bananen = new CharCollection("BANANEN"); // 0
		apfelstrudel = new CharCollection("APFELSTRUDEL"); // 1
		xyyzz = new CharCollection("XYYZZ"); // 2
		momentum = new CharCollection("MOMENTUM"); // 3
		test = new CharCollection("TEST"); // 4
		hochschule = new CharCollection("HOCHSCHULE"); // 5
		aaaaaa = new CharCollection("AAAAAA"); // 6
		abrakadabra = new CharCollection("ABRAKADABRA"); // 7
		wald = new CharCollection("WALD"); // 8
		leer = new CharCollection(""); // 9

		/*System.out.println(bananen.toString());
		System.out.println(apfelstrudel.toString());
		System.out.println(xyyzz.toString());
		System.out.println(momentum.toString());
		System.out.println(test.toString());
		System.out.println(hochschule.toString());
		System.out.println(aaaaaa.toString());
		System.out.println(abrakadabra.toString());
		System.out.println(wald.toString());
		System.out.println(leer.toString());*/

	}


	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);



	private static int counter = 1;

	@Rule
	public TestWatcher watcher = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			System.out.println("\n___________________________________________\n\nSTARTING TEST " + counter + ": '"
					+ description.getMethodName() + "'...");
			counter++;
		}

		@Override
		protected void finished(Description description) {
			System.out.println("FINISHED TEST: " + description.getMethodName()
					+ ".\n___________________________________________\n");
		}

		@Override
		protected void succeeded(Description description) {
			System.out.println("PASSED TEST: " + description.getMethodName());
		}

		@Override
		protected void failed(Throwable e, Description description) {
			if (e instanceof TestTimedOutException) {
				System.err.println("\"--> ERROR(s) in '" + description.getMethodName()
						+ "' - beendet aufgrund eines Timeouts!\nBitte vor Abgabe von Aufgaben pruefen auf Endlosschleifen. ");

			}

			System.out.println("FAILED TEST: " + description.getMethodName());
		}

		@Override
		protected void skipped(AssumptionViolatedException e, Description description) {
			System.err.println("An error occured during the JUnit-Test '" + description.getMethodName() + "':\n"
					+ e.toString() + "\n\nPLEASE CONTACT AN ADMIN");
		}

	};




	@Test
	public void testSize() {
		assertEquals("BANANEN hat 7 Zeichen", 7, bananen.size());
		assertEquals("APFELSTRUDEL hat 12 Zeichen", 12, apfelstrudel.size());
		assertEquals("XYYZZ hat 5 Zeichen", 5, xyyzz.size());
		assertEquals("MOMENTUM hat 8 Zeichen", 8, momentum.size());
		assertEquals("TEST hat 4 Zeichen", 4, test.size());
		assertEquals("HOCHSCHULE hat 10 Zeichen", 10, hochschule.size());
		assertEquals("AAAAAA hat 6 Zeichen", 6, aaaaaa.size());
		assertEquals("ABRAKADABRA hat 11 Zeichen", 11, abrakadabra.size());
		assertEquals("WALD hat 4 Zeichen", 4, wald.size());
		assertEquals("Leere Sammlung hat 0 Zeichen", 0, leer.size());
	}

	@Test
	public void testCount() {
		assertEquals("BANANEN enthaelt 2x A", 2, bananen.count('A'));
		assertEquals("APFELSTRUDEL enthaelt 0x X", 0, apfelstrudel.count('X'));
		assertEquals("XYYZZ enthaelt 2x Y", 2, xyyzz.count('Y'));
		assertEquals("MOMENTUM enthaelt 3x M", 3, momentum.count('M'));
		assertEquals("TEST enthaelt 2x T", 2, test.count('T'));
		assertEquals("HOCHSCHULE enthaelt 3x H", 3, hochschule.count('H'));
		assertEquals("AAAAAA enthaelt 6x A", 6, aaaaaa.count('A'));
		assertEquals("ABRAKADABRA enthaelt 5x A", 5, abrakadabra.count('A'));
		assertEquals("WALD enthaelt 1x W", 1, wald.count('W'));
		assertEquals("Leere Sammlung enthaelt 0x Z", 0, leer.count('Z'));
	}

	@Test
	public void testDifferent() {
		assertEquals("BANANEN enthaelt 4 verschiedene Buchstaben", 4, bananen.different());
		assertEquals("APFELSTRUDEL enthaelt 10 verschiedene Buchstaben", 10, apfelstrudel.different());
		assertEquals("XYYZZ enthaelt 3 verschiedene Buchstaben", 3, xyyzz.different());
		assertEquals("MOMENTUM enthaelt 6 verschiedene Buchstaben", 6, momentum.different());
		assertEquals("TEST enthaelt 3 verschiedene Buchstaben", 3, test.different());
		assertEquals("HOCHSCHULE enthaelt 7 verschiedene Buchstaben", 7, hochschule.different());
		assertEquals("AAAAAA enthaelt 1 verschiedenen Buchstaben", 1, aaaaaa.different());
		assertEquals("ABRAKADABRA enthaelt 5 verschiedene Buchstaben", 5, abrakadabra.different());
		assertEquals("WALD enthaelt 4 verschiedene Buchstaben", 4, wald.different());
		assertEquals("Leere Sammlung enthaelt 0 verschiedene Buchstaben", 0, leer.different());
	}

	@Test
	public void testTop() {
		assertEquals("BANANEN: haeufigster Buchstabe ist N", 'N', bananen.top());
		assertEquals("MOMENTUM: haeufigster Buchstabe ist M (2x)", 'M', momentum.top());
		assertEquals("TEST: haeufigster Buchstabe ist T (2x)", 'T', test.top());
		assertEquals("HOCHSCHULE: haeufigster Buchstabe ist H (3x)", 'H', hochschule.top());
		assertEquals("AAAAAA: haeufigster Buchstabe ist A (6x)", 'A', aaaaaa.top());
		assertEquals("ABRAKADABRA: haeufigster Buchstabe ist A (5x)", 'A', abrakadabra.top());
		assertTrue("WALD: alle Buchstaben kommen 1x vor", wald.count(wald.top()) == 1);
		assertEquals("Leere Sammlung: top() == 0", 0, leer.top());
	}

	@Test
	public void testEquals() {
		assertTrue("BANANEN == NEBANAN", bananen.equals(new CharCollection("NEBANAN")));
		assertFalse("APFELSTRUDEL == ELTFARPUDS", apfelstrudel.equals(new CharCollection("ELTFARPUDS")));
		assertFalse("XYYZZ != MOMENTUM", xyyzz.equals(momentum));
		assertTrue("AAAAAA == AAAAAA", aaaaaa.equals(new CharCollection("AAAAAA")));
		assertTrue("WALD == 'DLAW' (String)", wald.equals(new CharCollection("DLAW")));
		assertFalse("\"\" != null", leer.equals(null));
	}

	@Test
	public void testToStringFormat() {
		assertEquals("Rueckgabe sollte '(B, A, N, A, N, E, N)' sein", bananen.toString(), "(B, A, N, A, N, E, N)");
		assertEquals("Rueckgabe sollte '(A, P, F, E, L, S, T, R, U, D, E, L)' sein", apfelstrudel.toString(), "(A, P, F, E, L, S, T, R, U, D, E, L)");
		assertEquals("Rueckgabe sollte '(X, Y, Y, Z, Z)' sein", xyyzz.toString(), "(X, Y, Y, Z, Z)");
		assertEquals("Rueckgabe sollte '(M, O, M, E, N, T, U, M)' sein", momentum.toString(), "(M, O, M, E, N, T, U, M)");
		assertEquals("Rueckgabe sollte '(T, E, S, T)' sein", test.toString(), "(T, E, S, T)");
		assertEquals("Rueckgabe sollte '(H, O, C, H, S, C, H, U, L, E)' sein", hochschule.toString(), "(H, O, C, H, S, C, H, U, L, E)");
		assertEquals("Rueckgabe sollte '(A, A, A, A, A, A)' sein", aaaaaa.toString(), "(A, A, A, A, A, A)");
		assertEquals("Rueckgabe sollte '(A, B, R, A, K, A, D, A, B, R, A)' sein", abrakadabra.toString(), "(A, B, R, A, K, A, D, A, B, R, A)");
		assertEquals("Rueckgabe sollte '(W, A, L, D)' sein", wald.toString(), "(W, A, L, D)");
		assertEquals("Rueckgabe sollte '()' sein", leer.toString(), "()");

	}

	@Test
	public void testMoreThan() {
		assertEquals("BANANEN moreThan(1): erwartet ANANN", new CharCollection("ANANN"), bananen.moreThan(1));
		assertEquals("BANANEN moreThan(2): erwartet NNN", new CharCollection("NNN"), bananen.moreThan(2));
		assertEquals("HOCHSCHULE moreThan(1): erwartet CCHHH", new CharCollection("HCHCH"), hochschule.moreThan(1));
		assertEquals("AAAAAA moreThan(3): erwartet AAAAAA", new CharCollection("AAAAAA"), aaaaaa.moreThan(3));
		assertEquals("APFELSTRUDEL moreThan(4): leer", new CharCollection(""), apfelstrudel.moreThan(4));

	}

	@Test
	public void testExcept() {
		assertEquals("BANANEN ohne BEN = AA", new CharCollection("AANN"),
				bananen.except(new CharCollection("BEN")));
		assertEquals("APFELSTRUDEL ohne STRUDEL = APFEL", new CharCollection("APFEL"),
				apfelstrudel.except(new CharCollection("STRUDEL")));
		assertEquals("AAAAAA ohne A = AAAAA", new CharCollection("AAAAA"), aaaaaa.except(new CharCollection("A")));
		assertEquals("WALD ohne X = WALD", wald, wald.except(new CharCollection("X")));
		assertEquals("MOMENTUM ohne leer = MOMENTUM", momentum, momentum.except(new CharCollection()));
	}

	@Test
	public void testIsSubset() {
		// Identische Sammlungen
		assertTrue("BANANEN enthaelt BANANEN", bananen.isSubset(new CharCollection("BANANEN")));
		assertTrue("Leere Sammlung enthaelt leere Sammlung", leer.isSubset(new CharCollection("")));
		assertTrue("AAAAAA enthaelt AAAAAA", aaaaaa.isSubset(new CharCollection("AAAAAA")));

		// Echte Teilmengen
		assertTrue("BANANEN enthaelt NANEBA", bananen.isSubset(new CharCollection("NANEBA")));
		assertTrue("BANANEN enthaelt BAN", bananen.isSubset(new CharCollection("BAN")));
		assertTrue("BANANEN enthaelt NN", bananen.isSubset(new CharCollection("NN")));
		assertTrue("BANANEN enthaelt AA", bananen.isSubset(new CharCollection("AA")));
		assertTrue("ABRAKADABRA enthaelt ARKA", abrakadabra.isSubset(new CharCollection("ARKA")));
		assertTrue("HOCHSCHULE enthaelt HCH", hochschule.isSubset(new CharCollection("HCH")));
		assertTrue("WALD enthaelt W", wald.isSubset(new CharCollection("W")));
		assertTrue("Jede Sammlung enthaelt die leere Sammlung", bananen.isSubset(new CharCollection("")));
		assertTrue("Auch XYYZZ enthaelt die leere Sammlung", xyyzz.isSubset(new CharCollection("")));

		// Reihenfolge darf egal sein
		assertTrue("Reihenfolge spielt keine Rolle: TEST enthaelt TSET", test.isSubset(new CharCollection("TSET")));
		assertTrue("Reihenfolge spielt keine Rolle: MOMENTUM enthaelt UMMO", momentum.isSubset(new CharCollection("UMMO")));

		// Falsche Vielfachheiten
		assertFalse("BANANEN enthaelt nicht AAA", bananen.isSubset(new CharCollection("AAA")));
		assertFalse("TEST enthaelt nicht TTT", test.isSubset(new CharCollection("TTT")));
		assertFalse("XYYZZ enthaelt nicht YYY", xyyzz.isSubset(new CharCollection("YYY")));
		assertFalse("AAAAAA enthaelt nicht AAAAAAA", aaaaaa.isSubset(new CharCollection("AAAAAAA")));
		assertFalse("ABRAKADABRA enthaelt nicht BBB", abrakadabra.isSubset(new CharCollection("BBB")));

		// Fremde Buchstaben
		assertFalse("BANANEN enthaelt nicht X", bananen.isSubset(new CharCollection("X")));
		assertFalse("BANANEN enthaelt nicht BANANEX", bananen.isSubset(new CharCollection("BANANEX")));
		assertFalse("WALD enthaelt nicht Z", wald.isSubset(new CharCollection("Z")));
		assertFalse("Leere Sammlung enthaelt nicht A", leer.isSubset(new CharCollection("A")));

		// Obermengen sind keine Teilmengen
		assertFalse("BANANEN enthaelt nicht BANANENA", bananen.isSubset(new CharCollection("BANANENA")));
		assertFalse("TEST enthaelt nicht TESTE", test.isSubset(new CharCollection("TESTE")));
		assertFalse("WALD enthaelt nicht WALDW", wald.isSubset(new CharCollection("WALDW")));

		// Gleiche Buchstabenmenge, aber ungueltige Anzahl
		assertFalse("BANANEN enthaelt nicht AAAAAAA", bananen.isSubset(new CharCollection("AAAAAAA")));
		assertFalse("HOCHSCHULE enthaelt nicht HHHH", hochschule.isSubset(new CharCollection("HHHH")));
		assertFalse("MOMENTUM enthaelt nicht MMMM", momentum.isSubset(new CharCollection("MMMM")));

		// Leere Sammlung nur Teilmenge von jeder Sammlung, aber enthaelt selbst nur leer
		assertTrue("Leere Teilmenge in leer", leer.isSubset(new CharCollection("")));
		assertFalse("Leere Sammlung enthaelt keine nichtleere Sammlung", leer.isSubset(new CharCollection("BAN")));
	}

}
