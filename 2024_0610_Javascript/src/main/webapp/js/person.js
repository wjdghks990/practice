/**
 * 
 */

 class Person {
	
	constructor(name,age,tel) {
		this.name	= name;
		this.age	= age;
		this.tel	= tel;
	}
	
	// setter
	set age(nai){
		
		if(nai<0){
			console.log("나이가 음수면 안돼")
		}
		// private name : _변수명
		this._age = nai; /*재귀호출 방지하기 위해 변수명을 동일하게 하면 안됨*/
	}
	
	// getter
	get age(){
		return this._age; /*재귀호출 방지하기 위해 변수명을 동일하게 하면 안됨*/
	}
	
	/* 클래스 내부에서는 함수 앞에 function 사용 불가 */
	toJSON() {		
		return `{"name":"${this.name}", "age":"${this.age}", "tel":"${this.tel}"}`; /* 자바와 달리 this 붙여야 함 */ 
	}
	
 }
 