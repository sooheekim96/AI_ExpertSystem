import java.util.List;

public class User {

	public static void main(String[] args) {
		Database database = new Database();
		KnowledgeBase knowledgeBase = new KnowledgeBase();
		InferenceEngine inferenceEngine = new InferenceEngine(knowledgeBase, database);
				
		Rule rule;
		// rule 1
		rule = Rule.create(Fact.create("�ڱػ�Ȳ", "������"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "��"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "�Ŵ���"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "����"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "����"));
		knowledgeBase.addRule(rule);
		// rule 2
		rule = Rule.create(Fact.create("�ڱػ�Ȳ", "�ð���"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "�׸�"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "�Ϸ���Ʈ"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "����"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "��ǥ"));
		knowledgeBase.addRule(rule);
		// rule3
		rule = Rule.create(Fact.create("�ڱػ�Ȳ", "����"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "���"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "�ǹ�"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "����"));
		knowledgeBase.addRule(rule);
		// rule4
		rule = Rule.create(Fact.create("�ڱػ�Ȳ", "��ȣ��"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "����"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "����"));
		rule.addConditionOr(Fact.create("�۾�ȯ��", "��ǻ�� ���α׷�"));
		knowledgeBase.addRule(rule);
		// rule5
		rule = Rule.create(Fact.create("�ڱع���", "�����"));
		rule.addConditionOr(Fact.create("����", "�����ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "�����ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "����ϴ� ��"));
		knowledgeBase.addRule(rule);
		// rule6
		rule = Rule.create(Fact.create("�ڱع���", "�ǹ�"));
		rule.addConditionOr(Fact.create("����", "����� ��"));
		rule.addConditionOr(Fact.create("����", "�����ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "�����ϴ� ��"));
		knowledgeBase.addRule(rule);
		// rule7
		rule = Rule.create(Fact.create("�ڱع���", "����ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "���� ��"));
		rule.addConditionOr(Fact.create("����", "Ÿ�����ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "�׸��� ��"));
		knowledgeBase.addRule(rule);
		// rule8
		rule = Rule.create(Fact.create("�ڱع���", "�м���"));
		rule.addConditionOr(Fact.create("����", "���ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "�߷��ϴ� ��"));
		rule.addConditionOr(Fact.create("����", "�����ϴ� ��"));
		knowledgeBase.addRule(rule);
		// rule9
		rule = Rule.create(Fact.create("����", "��ũ��"));
		rule.addConditionAnd(Fact.create("�ڱػ�Ȳ", "��ü"));
		rule.addConditionAnd(Fact.create("�ڱع���", "�ǹ�"));
		rule.addConditionAnd(Fact.create("�ǵ��", "�ʿ��ϴ�"));
		knowledgeBase.addRule(rule);
		// rule10
		rule = Rule.create(Fact.create("����", "����-Ʃ�丮��"));
		rule.addConditionAnd(Fact.create("�ڱػ�Ȳ", "��ȣ"));
		rule.addConditionAnd(Fact.create("�ڱع���", "�м���"));
		rule.addConditionAnd(Fact.create("�ǵ��", "�ʿ��ϴ�"));
		knowledgeBase.addRule(rule);
		// rule11
		rule = Rule.create(Fact.create("����", "����ī��Ʈ"));
		rule.addConditionAnd(Fact.create("�ڱػ�Ȳ", "�ð���"));
		rule.addConditionAnd(Fact.create("�ڱع���", "���"));
		rule.addConditionAnd(Fact.create("�ǵ��", "�ʿ����"));
		knowledgeBase.addRule(rule);
		// rule12
		rule = Rule.create(Fact.create("����", "����-Ʃ�丮��"));
		rule.addConditionAnd(Fact.create("�ڱػ�Ȳ", "�ð���"));
		rule.addConditionAnd(Fact.create("�ڱع���", "�����"));
		rule.addConditionAnd(Fact.create("�ǵ��", "�ʿ��ϴ�"));
		knowledgeBase.addRule(rule);
		// rule13
		rule = Rule.create(Fact.create("����", "����-Ʃ�丮��"));
		rule.addConditionAnd(Fact.create("�ڱػ�Ȳ", "������"));
		rule.addConditionAnd(Fact.create("�ڱع���", "�м���"));
		rule.addConditionAnd(Fact.create("�ǵ��", "�ʿ��ϴ�"));
		knowledgeBase.addRule(rule);
		// rule14
		rule = Rule.create(Fact.create("����", "���� ���� ����"));
		rule.addConditionAnd(Fact.create("�ڱػ�Ȳ", "������"));
		rule.addConditionAnd(Fact.create("�ڱع���", "�����"));
		rule.addConditionAnd(Fact.create("�ǵ��", "�ʿ��ϴ�"));
		knowledgeBase.addRule(rule);
		
		// ������ ���� ������ �������� db�� factȭ���� �߰�.
		// Ȥ�� ������ ���� ������ �ƴ϶� ������ fact�� �߰��ص���
		database.addFact(Fact.create("�۾�ȯ��", "��"));
		database.addFact(Fact.create("����", "�����ϴ� ��"));
		database.addFact(Fact.create("�ǵ��", "�ʿ��ϴ�"));
		
		inferenceEngine.startInference();
		System.out.println();
		List<Fact> listFactSolution = database.getListFactByKey("����");
		if (listFactSolution == null) {
			System.out.println("�˼��մϴ�. ��ſ��� ������ �ַ���� �����ϴ�.");
		} else {
			System.out.println("��ſ��� ������ ���� ����Դϴ�.");
			for (Fact fact : listFactSolution)
				System.out.println(fact);
		}
	}

}
