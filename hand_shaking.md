# 3-way / 4-way Handshake
<!--Table of Contents-->
- 3-way Handshake
- 4-way Handshake
- Round Robin Scheduling의 예시

<!-- 어떤 질문을 대답할 수 있어야 하는지-->
## You can answer
- 3-way Handshake란?
- 4-way Handshake란?
<!--Contents-->

---
## 3-way / 4-way Handshake

### 3-way Handshake란?
TCP 통신을 이용하여 데이터를 전송하기 위해 네트워크 연결을 설정(Connection Establish) 하는 과정입니다.  

양쪽 모두 데이터를 전송할 준비가 되었다는 것을 보장하고, 실제로 데이터 전달이 시작하기 전에 한 쪽이 다른 쪽이 준비되었다는 것을 알 수 있도록 합니다.
즉, TCP/IP 프로토콜을 이용해서 통신을 하는 응용 프로그램이 데이터를 전송하기 전에 먼저 정확한 전송을 보장하기 위해 상대방 컴퓨터와 사전에 세션을 수립하는 과정을 의미합니다.  


Client > Server : TCP SYN  

Server > Client : TCP SYN ACK  

Client > Server : TCP ACK  



여기서 SYN은 'synchronize sequence numbers', 그리고 ACK는'acknowledgment' 의 약자입니다. 이러한 절차는 TCP 접속을 성공적으로 성립하기 위하여 반드시 필요합니다.


### TCP의 3-way Handshaking 과정

![image](https://user-images.githubusercontent.com/22022393/136329558-59936ba5-04d0-46b1-88d3-c1240dee82c3.png)  

[STEP 1]  

A클라이언트는 B서버에 접속을 요청하는 SYN 패킷을 보냅니다. 이때 A클라이언트는 SYN 을 보내고 SYN/ACK 응답을 기다리는SYN_SENT 상태가 되는 것입니다.  



[STEP 2]  

B서버는 SYN요청을 받고 A클라이언트에게 요청을 수락한다는 ACK 와 SYN flag 가 설정된 패킷을 발송하고 A가 다시 ACK으로 응답하기를 기다립니다. 이때 B서버는 SYN_RECEIVED 상태가 됩니다.  



[STEP 3]  

A클라이언트는 B서버에게 ACK을 보내고 이후로부터는 연결이 이루어지고 데이터가 오가게 되는것이다. 이때의 B서버 상태가 ESTABLISHED 입니다.

위와 같은 방식으로 통신하는것이 신뢰성 있는 연결을 맺어 준다는 TCP의 3 Way handshake 방식입니다.  


### 4-way Handshaking 란?

3-Way handshake는 TCP의 연결을 초기화 할 때 사용한다면, 4-Way handshake는 세션을 종료하기 위해 수행되는 절차입니다.  



### TCP의 4-way Handshaking 과정

![image](https://user-images.githubusercontent.com/22022393/136329777-2283a420-7421-440d-974b-69f1eb247354.png)  


[STEP 1]  

클라이언트가 연결을 종료하겠다는 FIN플래그를 전송한다. 이때 A클라이언트는  FIN-WAIT 상태가 됩니다.  

[STEP 2]  

B서버는 FIN플래그를 받고, 일단 확인메시지 ACK 보내고 자신의 통신이 끝날때까지 기다리는데  
이 상태가 B서버의 CLOSE_WAIT상태입니다.  

[STEP 3]  

연결을 종료할 준비가 되면, 연결해지를 위한 준비가 되었음을 알리기 위해  클라이언트에게 FIN플래그를 전송하는데  
이때 B서버의 상태는 LAST-ACK입니다.  

[STEP 4]  

클라이언트는 해지준비가 되었다는 ACK를 확인했다는 메시지를 보냅니다.  
A클라이언트의 상태가 FIN-WAIT ->TIME-WAIT 으로 변경됩니다.  

---
### 참고
- 포트(PORT) 상태 정보
1. CLOSED: 포트가 닫힌 상태
2. LISTEN: 포트가 열린 상태로 연결 요청 대기 중
3. SYN_RCV: SYNC 요청을 받고 상대방의 응답을 기다리는 중
4. ESTABLISHED: 포트 연결 상태

- TCP Header 안의 플래그 정보  
 TCP Header에는 CONTROL BIT(플래그 비트, 6bit)가 존재하며, 각각의 bit는 “URG-ACK-PSH-RST-SYN-FIN”의 의미를 가진다.  
 즉, 해당 위치의 bit가 1이면 해당 패킷이 어떠한 내용을 담고 있는 패킷인지를 나타낸다.  
- SYN(Synchronize Sequence Number)  
 연결 설정 / 000010  
Sequence Number를 랜덤으로 설정하여 세션을 연결하는 데 사용하며, 초기에 Sequence Number를 전송한다.
- ACK(Acknowledgement)  
응답 확인 / 010000  
패킷을 받았다는 것을 의미한다.  
Acknowledgement Number 필드가 유효한지를 나타낸다.  
양단 프로세스가 쉬지 않고 데이터를 전송한다고 가정하면 최초 연결 설정 과정에서 전송되는 첫 번째 세그먼트를 제외한 모든 세그먼트의 ACK 비트는 1로 지정된다고 생각할 수 있다.  
- FIN(Finish)  
연결 해제 / 000001  
세션 연결을 종료시킬 때 사용되며, 더 이상 전송할 데이터가 없음을 의미한다.  

---
## Reference
- [방구의 개발냄새, 3-way / 4-way Handshake 란?](https://bangu4.tistory.com/74)
- [TCP 3-way handshaking과 4-way handshaking](https://gmlwjd9405.github.io/2018/09/19/tcp-connection.html)
