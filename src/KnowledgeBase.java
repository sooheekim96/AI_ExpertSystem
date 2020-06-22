import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnowledgeBase {
	final List<Rule> listRule = new ArrayList<Rule>();
	final Map<Fact, List<Rule>> mapRuleRelatedFact = new HashMap<Fact, List<Rule>>();
	
	boolean addRule(Rule rule) {
		if (rule == null || (rule.listFactConditionAnd.isEmpty() && rule.listFactConditionOr.isEmpty())) {
			System.out.println("KnowledgeBase.addRule() failed. Wrong Rule type");
			return false;
		}
		for (Fact factCondition: rule.listFactConditionAll) {
			List<Rule> listRuleRelated = mapRuleRelatedFact.get(factCondition);
			if (listRuleRelated == null) {
				listRuleRelated = new ArrayList<Rule>();
				mapRuleRelatedFact.put(factCondition, listRuleRelated);
			}
			listRuleRelated.add(rule);
		}
		listRule.add(rule);
		System.out.println("KnowledgeBase.addRule() Added. " + rule);
		return true;
	}
}

class Rule {
	final Fact factToBeIgnited;
	boolean ignited;
	final List<Fact> listFactConditionAll = new ArrayList<Fact>();
	final List<Fact> listFactConditionAnd = new ArrayList<Fact>();
	final List<Fact> listFactConditionOr = new ArrayList<Fact>();

	private Rule(Fact _factToBeIgnited) {
		factToBeIgnited = _factToBeIgnited;
	}
	
	public static Rule create(Fact _factToBeIgnited) {
		if (_factToBeIgnited == null) {
			System.out.println("Rule.create() failed. fact is null");
			return null;
		}
		return new Rule(_factToBeIgnited);
	}

	public void addConditionAnd(Fact factCondition) {
		listFactConditionAll.add(factCondition);
		listFactConditionAnd.add(factCondition);
	}

	public void addConditionOr(Fact factCondition) {
		listFactConditionAll.add(factCondition);
		listFactConditionOr.add(factCondition);
	}

	@Override
	public String toString() {
		String ret = "<Rule: Then(" + factToBeIgnited + ") |";
		for (Fact fact : listFactConditionAnd)
			ret += " And(" + fact + ")";
		for (Fact fact : listFactConditionOr)
			ret += " Or(" + fact + ")";
		ret += ">";
		return ret;
	}
}
