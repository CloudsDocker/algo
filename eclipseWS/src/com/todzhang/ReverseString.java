To reverse a array

Public String reverse(String intput){
	Byte[] ary=input.toCharArray();
	Int len=ary.length-1;
	For(int i=0;i<=(len/2);i++){
		Byte tmp=ary[i];
		Ary[len-i]=ary[i];
		Ary[i]=tep;
	}
	Return new String(ary);
}

Public String reverse2(String input){
StringBuffer a=new StringBuffer(input);
Return a.reverse().toString();
}

Public String reverse3(String input){
Char[] ary=input.toCharArray();
Int left=0;
Int right=ary.length-1;
Char temp;
Whiel(right>left){
	Temp=ary[left];
	Ary[left]=ary[right];
	Ary[right]=temp;
	Right--;
	Left++;
}
Return new String(ary);
}

Public String reverse4(String input){
	Int len=input.length;
	StringBuffer dest=new STringBuffer(len);  // if concurrency is not a concern, replace it with StringBuilder after Java 5, as StringBuilder is fatster
	For(int i=(len-1);i>=0;i--){
		Dest.append(input.charAt(i));
}
Return dest.toString();
}


// using reverse approach
Public String reverse5(String input){
	Return reverse(input,input.length-1);
}

String reverse(String input, int index){
	If(index==0){
		Return input.charAt(0)+””;
}

Char tmp=input.chartAt(index);
Return tmp+reverse(input,index-1);
}


// use stack approach
Public String reverse6(String input){
	Stack<Character> queue=new Stack<Character>();
	For(int i=0;i<input.length()-1;i++){
		Queue.push(input.charAt(i);
}
StringBuilder sb=new StringBuilder();
While(!queue.isEmpty()){
	Sb.append(queue.pop());
}
Return sb.toString();
}

// using XOR approach, based on 
// (A XOR B) XOR B=A
// (A XOR B) XOR A=B

Public String reverse7(String input){
	Int low=0;
	Int hight=input.length-1;
	Char[] ary=input.toCharArray();
	While(low<hight){
		Ary[low]=(char)(char[low]^char[high]);
		Ary[high]=(char)(char[low]^char[high]);
		Ary[low]=(char)(char[low]^char[high]);
		Low++;
		High—;
	}
	Return new String(ary);
}


// use StringTokenizer approach
Public String reverse8(String input){
	StringTokenizer st=new StringTokenizer(input);
	Stack<String> stack=new Stack<>();
	While(st.hasMoreTokens()){
		Stack.push(st.nextTokens());
	}

	StringBuffer sb=new StringBuffer();
	While(!stack.isEmpty()){
		Sb.append(stack.pop());
}
Return sb.toString();
}

// the last one is logic implemented in AbstractStringBuilder
Public String reverse9(String input){
	Int n=input.count-1;
	Char[] value=input.toCharArray();
	For(int i=(n-1)>>1;i>=0;--i){
		Char tmp=value[i];
		Char tmp2=value[n-i];
		Value[i]=tmp2;
		Value[n-i]=tmp;
	}
	Return new String(value);
}



Regards,

Todd Zhang PMP 张磊 
HSBC Operations, Services & Technology (HOST) GB&M, Project Management | The Hongkong and Shanghai Banking Corporation Limited
29/F, HSBC Building, Shanghai IFC, 8 Century Avenue, Shanghai 200120
___________________________________________________________________________________

Phone.     86-21-38883959; 71862183959
Mobile.      135 2430 6108
Email.       todd.zhang@hsbc.com.cn
___________________________________________________________________________________

