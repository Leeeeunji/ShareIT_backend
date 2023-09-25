 SET FOREIGN_KEY_CHECKS = 0;
 TRUNCATE question;
 TRUNCATE member;
 TRUNCATE answer;
 TRUNCATE question_answers;
 TRUNCATE tendency;
 SET FOREIGN_KEY_CHECKS = 1;
 INSERT INTO question (QUESTION_ID, NUM, CONTENT)
 VALUES
     (1, 1, "첫 조별과제다. 다들 말이없다. 내가 먼저 말을 꺼내야하나? 이러면 조장인데?"),
     (2, 2, "시간이 흘러 조별과제 발표날이 되었다. 발표하기로 맡은 팀원이 갑자기 연락이 안된다. 어떡하지???"),
     (3, 3, "팀원이 소통의 문제로 똑같은 부분의 코드를 짜왔다. 어떻게 해결해야되지?"),
     (4, 4, "당신은 좀비 아포칼립스 세상에 있습니다. 어떻게 하실껀가요?"),
     (5, 5, "개발을 진행할 때, 보통 어떤스타일로 개발을 하나요?"),
     (6, 6, "당신은 친구들과 해커톤에 나가기로 결심했습니다. 친구들과 아이디어를 논의 후 작업물을 만들기로 했습니다. 당신은 어떻게 작업하시나요?"),
     (7, 7, "친구랑 약속때문에 가는데 살짝 지각이다. 이대로는 늦겠어!!! 어떡하지???"),
     (8, 8, "친구를 만났는데 친구 표정이 뚱하다. 어떻게 해야 하지?"),
     (9, 9, "개발을 진행하다가 같은 팀원이 원인모를 에러로 당신에게 코드리뷰를 부탁하고 있다. 어떻게 얘기를 할까?"),
     (10, 10, "친구랑 여행을 갔다! 기차역에서 내리니까 공기가 좋다. 밥은 뭐먹지? 아 저기 맛있어 보인다! 저기로 가볼까?"),
     (11, 11, "작업물 할 께 왜 이렇게 많지? 회의하다 보니까 너무 작업물이 쌓였네.이거 어떻게 해결하지?"),
     (12, 12, "학교에서 기획서를 써야되는 상황이 발생하였다. 팀원들과 논의를 하게 되었다. 당신은 어떤 의견을 내실건가요?")
 ;

 INSERT INTO answer (ten_typeie, ten_typens, ten_typepj, ten_typetf, content, member_id, question_id, num, answer_id)
 VALUES
 	(1, 0, 0, 0, "에이 모르겠다. 내가 해야겠다.", null, 1, 1, 11),
     (-1, 0, 0, 0, "아 좀 어색한데? 그냥 조용히 있어야지", null, 1, 2, 12),
     (1, 0, 0, 0, "아 그냥 내가 하지 뭐. 그대신 이름 무조건 뺀다!", null, 2, 1, 21),
     (-1, 0, 0, 0, "아 어떡하지? 어떡하지?", null, 2, 2, 22),
     (1, 0, 0, 0, "잘 소통해서 좋은 코드를 선택을 하자", null, 3, 1, 31),
     (-1, 0, 0, 0, "어...음...알아서 얘기 잘 해주시겠지? 안되면 내 코드 밀지 뭐...", null, 3, 2, 32),
     (0, 1, 0, 0, "일단은 생존에 앞서 생존물자를 구하고 주저리주저리..", null, 4, 1, 41),
     (0, -1, 0, 0, "그걸 왜 생각하나요?", null, 4, 2, 42),
     (0, 1, 0, 0, "미리 개발 구조를 생각하면서 개발을 진행한다.", null, 5, 1, 51),
     (0, -1, 0, 0, "일단 프로그램 잘 돌아가는거 보기위해 개발을 진행한다.", null, 5, 2, 52),
     (0, 1, 0, 0, "전반적인 아이디어를 고려하며 디자인과 함께 작업물을 만든다.", null, 6, 1, 61),
     (0, -1, 0, 0, "일단 작업물을 만들고 디자인은 나중에 생각하자", null, 6, 2, 62),
     (0, 0, 1, 0, "네이버 지도를 켜서 제일 빠른 길로 간다.", null, 7, 1, 71),
     (0, 0, -1, 0, "에이, 내가 알던 길로 그냥 빨리 달려가자!", null, 7, 2, 72),
     (0, 0, 1, 0, "너 표정이 안좋아 괜찮아?", null, 8, 1, 81),
     (0, 0, -1, 0, "너 표정이 안좋아 뭔일있어?", null, 8, 2, 82),
     (0, 0, 1, 0, "(코드를 자세히 본다) 흠...그거 그대로 복사해서 구글링해봐.", null, 9, 1, 91),
     (0, 0, -1, 0, "고생이 많네 머리 아프지? 나도 좀 같이 고민해보자", null, 9, 2, 92),
     (0, 0, 0, -1, "아 내가 여기 찾아본 맛집이 있어 그냥 거기 더 가고싶은데 거기로 가자", null, 10, 1, 101),
     (0, 0, 0, 1, "아 맛있겠당 빨리 가서 먹어야지~", null, 10, 2, 102),
     (0, 0, 0, -1, "당황하지 않고, 조금씩 정리해서 어떻게 할지 계획하자", null, 11, 1, 111),
     (0, 0, 0, 1, "일단 맛난거부터 먹고 생각하자(배민을 키면서)", null, 11, 2, 112),
     (0, 0, 0, -1, "차근차근 역할을 나눠서 기획서 쓰시죠?", null, 12, 1, 121),
     (0, 0, 0, 1, "일단 서로 의논하면서 써볼까요?", null, 12, 2, 122)
 ;

 INSERT INTO question_answers (question_question_id, answers_answer_id)
 VALUES
 	(1, 11),
     (1, 12),
     (2, 21),
     (2, 22),
     (3, 31),
     (3, 32),
     (4, 41),
     (4, 42),
     (5, 51),
     (5, 52),
     (6, 61),
     (6, 62),
     (7, 71),
     (7, 72),
     (8, 81),
     (8, 82),
     (9, 91),
     (9, 92),
     (10, 101),
     (10, 102),
     (11, 111),
     (11, 112),
     (12, 121),
     (12, 122)
 ;

INSERT INTO MEMBER (member_id)
VALUES
	(1);

INSERT INTO TENDENCY (tendency_id, ten_typeie, ten_typens, ten_typepj, ten_typetf, type, member_id)
VALUES
	(1, 0, 0, 0, 0, null, 1);