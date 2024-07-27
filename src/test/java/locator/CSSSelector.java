package locator;

public class CSSSelector {

	//css selector 
	//1. id -> tag#id, #id
	//2. class -> tag.classname, .classname, .c1.c2.c3
	//3. parent > childtag
	//4. input[id='username']	css
	//5. input[id='username'][type='email'] - css
	//6. input[@id='username' and @type='email'] - xpath
	
	//7. contains in css --> input[id*=user] --> input[id*=name]
	//id= test__123 //input[id*=test__]
	
	//8. starts with --> input[id^='user']
	//9. ending with --> input[id$='name']
	
	//10. comma --> 
	
	//11 first-of-type in css: --> ul#categories>li:first-of-type
	
	//12 last-of-type in css: --> ul#categories>li:last-of-type
	
	//13 nth-of-type in css: --> ul#categories>li:nth-of-type(1) --> give size
	
	// nth-of-type in css: --> ul#categories>li:nth-of-type(10)
	
	//14. nth-of-type in css: --> ul#categories>li:nth-of-type(n) --> give all lis
	
	//15. sibling --> div.private-form__input-wrapper + div
	//16.  sibling --> div.private-form__input-wrapper + div.private-form__meta 
	//ul#categories>li:nth-of-type(1)+li --> immediate sibling
	//
}

