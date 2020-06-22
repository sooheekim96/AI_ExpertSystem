import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Database {
	
	private final Map<String, List<Fact>> mapFactWithKey = new HashMap<String, List<Fact>>();
	private final Map<String, List<Fact>> mapFactWithValue = new HashMap<String, List<Fact>>();
	final Set<Fact> setFact = new HashSet<Fact>();
	
	public boolean addFact(Fact fact) {
		if (fact == null) {
			System.out.println("Database.addFact() failed. fact is null");
			return false;
		}
		// mapFactWithKey
		List<Fact> listFactWithKey = mapFactWithKey.get(fact.key);
		if (listFactWithKey == null) {
			listFactWithKey = new ArrayList<Fact>();
			mapFactWithKey.put(fact.key, listFactWithKey);
		}
		if (listFactWithKey.contains(fact)) {
			System.out.println("Database.addFact() failed. Fact(key) already exists.");
			return false;
		}
		// mapFactWithValue
		List<Fact> listFactWithValue = mapFactWithKey.get(fact.value);
		if (listFactWithValue == null) {
			listFactWithValue = new ArrayList<Fact>();
			mapFactWithKey.put(fact.value, listFactWithValue);
		}
		if (listFactWithValue.contains(fact)) {
			System.out.println("Database.addFact() failed. Fact(value) already exists.");
			return false;
		}
		// Add
		listFactWithKey.add(fact);
		listFactWithValue.add(fact);
		setFact.add(fact);
		System.out.println("Database.addFact() Added. " + fact);
		return true;
	}

	public boolean isFactTrue(Fact fact) {
		return setFact.contains(fact);
	}

	public List<Fact> getListFactByKey(String key) {
		List<Fact> ret = mapFactWithKey.get(key);
		return (ret == null || ret.isEmpty()) ? null : ret;
	}

	public List<Fact> getListFactByValue(String key) {
		List<Fact> ret = mapFactWithKey.get(key);
		return (ret == null || ret.isEmpty()) ? null : ret;
	}
}

class Fact {
	final String key, value;

	@Deprecated
	final boolean denial; // deprecated
	
	private Fact(String _key, String _value, boolean _denial) {
		key = _key;
		value = _value;
		denial = _denial;
	}

	public static Fact create(String _key, String _value) {
		return create(_key, _value, true);
	}

	@Deprecated
	public static Fact create(String _key, String _value, boolean _denial) {
		if (_key == null || _value == null) {
			System.out.println("Fact.create() failed. Wrong Fact type");
			return null;
		}
		return new Fact(_key, _value, _denial);
	}
	
	@Override
	public int hashCode() {
		return (key + value + denial).hashCode();
	}

	@Override
	public boolean equals(Object _fact) {
		if (_fact instanceof Fact) {
			Fact fact = (Fact) _fact;
			return key.equals(fact.key) && value.equals(fact.value) && denial == fact.denial;
		}
		return false;
	}

	@Override
	public String toString() {
		return "[Fact: " + key + " => " + value + (denial ? "" : " (X)") + "]";
	}
}