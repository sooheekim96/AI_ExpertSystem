import java.util.ArrayList;
import java.util.List;

public class InferenceEngine {
	final KnowledgeBase knowledgeBase;
	final Database database;
	
	public InferenceEngine(KnowledgeBase _knowledgeBase, Database _database) {
		knowledgeBase = _knowledgeBase;
		database = _database;
	}

	public void startInference() {
		List<Rule> listRuleHaveToCheck = new ArrayList<Rule>();
		listRuleHaveToCheck.addAll(knowledgeBase.listRule);
		while (!listRuleHaveToCheck.isEmpty()) {
			Rule rule = listRuleHaveToCheck.get(0);
			listRuleHaveToCheck.remove(0);
			if (rule.ignited)
				continue;
			if (canRuleIgnite(rule)) {
				System.out.println("InferenceEngine.startInference() ignite " + rule);
				rule.ignited = true;
				database.addFact(rule.factToBeIgnited);
				List<Rule> listRuleRelated = knowledgeBase.mapRuleRelatedFact.get(rule.factToBeIgnited);
				if (listRuleRelated != null)
					listRuleHaveToCheck.addAll(0, listRuleRelated);
			}
		}
	}

	public boolean canRuleIgnite(Rule rule) {
		for (Fact fact : rule.listFactConditionAnd)
			if (!database.isFactTrue(fact))
				return false;
		boolean ret = rule.listFactConditionOr.isEmpty();
		for (Fact fact : rule.listFactConditionOr)
			if (database.isFactTrue(fact))
				return true;
		return ret;
	}
}
