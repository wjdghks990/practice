/**
 * 
 */

class Jumin {
	
	constructor(jumin_no) {
		this.jumin_no = jumin_no;
	}
	
	// this.jumin_no = "";
	
	/*
			내국인	외국인
			남 여		남 여
	1900	1  2	5  6
	2000	3  4	7  8
	1800	9  0
	
	
	*/
	
	// 출생년도
	getYear() {
		let year = parseInt(this.jumin_no.substr(0,2)); // 0번 인덱스부터 2글자	
		let gender = parseInt(this.jumin_no.charAt(7));
		
		switch(gender) 
		{
			case 1: case 2: case 5: case 6: year += 1900; break;	
			case 3: case 4: case 7: case 8: year += 2000; break;	
			default: year += 1800; 	
		}
		return year;
	}
	
	// 나이
	getAge() {
		let age = 2024 - this.getYear();
		return age;
	}
	
	// 띠
	getTti() {
		let tti = this.getYear()%12;

		// 자축인묘 진사오미 신유술해
		switch(tti) 
		{
			case 0: return "원숭이";
			case 1: return "닭"; 
			case 2: return "개"; 
			case 3: return "돼지"; 
			case 4: return "쥐"; 
			case 5: return "소"; 
			case 6: return "호랑이"; 
			case 7: return "토끼"; 
			case 8: return "용"; 
			case 9: return "뱀"; 	
			case 10: return "말"; 			 	
		}
		return "양";  
	}
	
	getGender() {
		let gender = parseInt(this.jumin_no.charAt(7));
		
		if(gender%2==1) return "남자";
		
		return "여자";
	}
	
	getSeason() {
		let season = parseInt(this.jumin_no.substr(2,2));
		switch(Math.floor(season/3)) 
		{
			case 1:  return "봄"; 
			case 2:  return  "여름";
			case 3:  return  "가을"; 
		}
		return "겨울";
	}
	
	getLocal() {
		let local = parseInt(this.jumin_no.substr(8,2));
		
		if(0 <= local && 8 >= local) return "서울";
		else if(9 <= local && 12 >= local)  return "부산";
		else if(13 <= local && 15 >= local) return "인천";
		else if(16 <= local && 25 >= local) return "경기";
		else if(26 <= local && 34 >= local) return "강원";
		else if(35 <= local && 39 >= local) return "충북";
		else if(40 <= local && 47 >= local) return "충남";
		else if(48 <= local && 55 >= local) return "전북";
		else if(56 <= local && 66 >= local) return "전남";
		else if(67 <= local && 80 >= local) return "경북";
		else if(81 <= local && 99 >= local) return "경남";
				
	}
	getGanji() {
		let gan = this.getYear()%10;
		let result1 = "";
		let result2 = "";
		switch(gan) 
		{
			case 0: result1 = "경"; break;
			case 1: result1 = "신"; break;
			case 2: result1 = "임"; break;
			case 3: result1 = "계"; break;
			case 4: result1 = "갑"; break;
			case 5: result1 = "을"; break;
			case 6: result1 = "병"; break;
			case 7: result1 = "정"; break;
			case 8: result1 = "무"; break;
			default : result1 = "기";
		}
		
		let ji = this.getYear()%12;
		switch(ji) 
		{
			case 0: result2 = "신"; break;
			case 1: result2 = "유"; break;
			case 2: result2 = "술"; break;
			case 3: result2 = "해"; break;
			case 4: result2 = "자"; break;
			case 5: result2 = "축"; break;
			case 6: result2 = "인"; break;
			case 7: result2 = "묘"; break;
			case 8: result2 = "진"; break;
			case 9: result2 = "사"; break;
			case 10: result2 = "오"; break;
			default : result2 = "미";
		}
		let result = result1 + result2;
		return result;
	}
	
	//주민번호 체크알고리즘
	//					01234567890123
	// this.jumin_no = "901222-1234568"
	//					2345670892345

	isValid(){
		
		let sum = 0;
		sum += parseInt(this.jumin_no.charAt(0)) * 2;
		sum += parseInt(this.jumin_no.charAt(1)) * 3;
		sum += parseInt(this.jumin_no.charAt(2)) * 4;
		sum += parseInt(this.jumin_no.charAt(3)) * 5;
		sum += parseInt(this.jumin_no.charAt(4)) * 6;
		sum += parseInt(this.jumin_no.charAt(5)) * 7;
		
		sum += parseInt(this.jumin_no.charAt(7)) * 8;
		sum += parseInt(this.jumin_no.charAt(8)) * 9;
		sum += parseInt(this.jumin_no.charAt(9)) * 2;
		sum += parseInt(this.jumin_no.charAt(10)) * 3;
		sum += parseInt(this.jumin_no.charAt(11)) * 4;
		sum += parseInt(this.jumin_no.charAt(12)) * 5;
		
		let check_sum = (11-(sum%11))%10;
		console.log("check_sum : ", check_sum);
		
		let last_num = parseInt(this.jumin_no.charAt(13));
		return check_sum == last_num;
	}	
	
	isValid2(){	
		let sum = 0;
		let count = 2;
		for(let i =0; i<13; i++) {
			if(i == 6) continue;
			else if(i==9) count = 2;
			else {
				sum += parseInt(this.jumin_no.charAt(i)) * count++;
			}
		} // end - for
		
		let check_sum = (11-(sum%11))%10;
		console.log("check_sum : ", check_sum);
		
		let last_num = parseInt(this.jumin_no.charAt(13));
		return check_sum == last_num;
	}	
	
} // end - class 


