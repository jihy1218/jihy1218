package controllrer;

import model.Reply;

public class ReplyController {

	// �޼ҵ�
	
	// 1. �������
	
	public static boolean add(int index, Reply reply) {
					// �Խù� ��ȣ , ��� ��ü
					// � �Խù��� ����� �߰��Ұ���
		try {
			BoardController.boardList.get(index).getReplylist().add(reply);
			return true;
		}catch(Exception e) {
			return false;
		}
			
		
	}
	
}
