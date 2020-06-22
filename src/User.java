import java.util.List;

public class User {

	public static void main(String[] args) {
		Database database = new Database();
		KnowledgeBase knowledgeBase = new KnowledgeBase();
		InferenceEngine inferenceEngine = new InferenceEngine(knowledgeBase, database);
				
		Rule rule;
		// rule 1
		rule = Rule.create(Fact.create("자극상황", "문어적"));
		rule.addConditionOr(Fact.create("작업환경", "논문"));
		rule.addConditionOr(Fact.create("작업환경", "매뉴얼"));
		rule.addConditionOr(Fact.create("작업환경", "문서"));
		rule.addConditionOr(Fact.create("작업환경", "참고서"));
		knowledgeBase.addRule(rule);
		// rule 2
		rule = Rule.create(Fact.create("자극상황", "시각적"));
		rule.addConditionOr(Fact.create("작업환경", "그림"));
		rule.addConditionOr(Fact.create("작업환경", "일러스트"));
		rule.addConditionOr(Fact.create("작업환경", "사진"));
		rule.addConditionOr(Fact.create("작업환경", "도표"));
		knowledgeBase.addRule(rule);
		// rule3
		rule = Rule.create(Fact.create("자극상황", "물건"));
		rule.addConditionOr(Fact.create("작업환경", "기계"));
		rule.addConditionOr(Fact.create("작업환경", "건물"));
		rule.addConditionOr(Fact.create("작업환경", "도구"));
		knowledgeBase.addRule(rule);
		// rule4
		rule = Rule.create(Fact.create("자극상황", "기호적"));
		rule.addConditionOr(Fact.create("작업환경", "숫자"));
		rule.addConditionOr(Fact.create("작업환경", "수식"));
		rule.addConditionOr(Fact.create("작업환경", "컴퓨터 프로그램"));
		knowledgeBase.addRule(rule);
		// rule5
		rule = Rule.create(Fact.create("자극반응", "언어적"));
		rule.addConditionOr(Fact.create("업무", "강의하는 것"));
		rule.addConditionOr(Fact.create("업무", "조언하는 것"));
		rule.addConditionOr(Fact.create("업무", "상담하는 것"));
		knowledgeBase.addRule(rule);
		// rule6
		rule = Rule.create(Fact.create("자극반응", "실무"));
		rule.addConditionOr(Fact.create("업무", "만드는 것"));
		rule.addConditionOr(Fact.create("업무", "수리하는 것"));
		rule.addConditionOr(Fact.create("업무", "조정하는 것"));
		knowledgeBase.addRule(rule);
		// rule7
		rule = Rule.create(Fact.create("자극반응", "기록하는 것"));
		rule.addConditionOr(Fact.create("업무", "쓰는 것"));
		rule.addConditionOr(Fact.create("업무", "타이핑하는 것"));
		rule.addConditionOr(Fact.create("업무", "그리는 것"));
		knowledgeBase.addRule(rule);
		// rule8
		rule = Rule.create(Fact.create("자극반응", "분석적"));
		rule.addConditionOr(Fact.create("업무", "평가하는 것"));
		rule.addConditionOr(Fact.create("업무", "추론하는 것"));
		rule.addConditionOr(Fact.create("업무", "조사하는 것"));
		knowledgeBase.addRule(rule);
		// rule9
		rule = Rule.create(Fact.create("수단", "워크샵"));
		rule.addConditionAnd(Fact.create("자극상황", "물체"));
		rule.addConditionAnd(Fact.create("자극반응", "실무"));
		rule.addConditionAnd(Fact.create("피드백", "필요하다"));
		knowledgeBase.addRule(rule);
		// rule10
		rule = Rule.create(Fact.create("수단", "강의-튜토리얼"));
		rule.addConditionAnd(Fact.create("자극상황", "기호"));
		rule.addConditionAnd(Fact.create("자극반응", "분석적"));
		rule.addConditionAnd(Fact.create("피드백", "필요하다"));
		knowledgeBase.addRule(rule);
		// rule11
		rule = Rule.create(Fact.create("수단", "비디오카세트"));
		rule.addConditionAnd(Fact.create("자극상황", "시각적"));
		rule.addConditionAnd(Fact.create("자극반응", "기록"));
		rule.addConditionAnd(Fact.create("피드백", "필요없다"));
		knowledgeBase.addRule(rule);
		// rule12
		rule = Rule.create(Fact.create("수단", "강의-튜토리얼"));
		rule.addConditionAnd(Fact.create("자극상황", "시각적"));
		rule.addConditionAnd(Fact.create("자극반응", "언어적"));
		rule.addConditionAnd(Fact.create("피드백", "필요하다"));
		knowledgeBase.addRule(rule);
		// rule13
		rule = Rule.create(Fact.create("수단", "강의-튜토리얼"));
		rule.addConditionAnd(Fact.create("자극상황", "문어적"));
		rule.addConditionAnd(Fact.create("자극반응", "분석적"));
		rule.addConditionAnd(Fact.create("피드백", "필요하다"));
		knowledgeBase.addRule(rule);
		// rule14
		rule = Rule.create(Fact.create("수단", "역할 연기 연습"));
		rule.addConditionAnd(Fact.create("자극상황", "문어적"));
		rule.addConditionAnd(Fact.create("자극반응", "언어적"));
		rule.addConditionAnd(Fact.create("피드백", "필요하다"));
		knowledgeBase.addRule(rule);
		
		// 유저가 답한 내용을 바탕으로 db에 fact화시켜 추가.
		// 혹은 유저가 답한 정보가 아니라 사전에 fact를 추가해도됨
		database.addFact(Fact.create("작업환경", "논문"));
		database.addFact(Fact.create("업무", "강의하는 것"));
		database.addFact(Fact.create("피드백", "필요하다"));
		
		inferenceEngine.startInference();
		System.out.println();
		List<Fact> listFactSolution = database.getListFactByKey("수단");
		if (listFactSolution == null) {
			System.out.println("죄송합니다. 당신에게 적절한 솔루션이 없습니다.");
		} else {
			System.out.println("당신에게 적합한 수단 목록입니다.");
			for (Fact fact : listFactSolution)
				System.out.println(fact);
		}
	}

}
