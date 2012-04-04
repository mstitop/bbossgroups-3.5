/*
 *  Copyright 2008 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.frameworkset.util;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Title: VariableHandler.java</p> 
 * <p>Description: ������������ </p>
 * <p>bboss workgroup</p>
 * <p>Copyright (c) 2008</p>
 * @Date 2009-12-16 ����11:34:31
 * @author biaoping.yin
 * @version 1.0
 */
public class VariableHandler
{
    public static String default_regex = "\\$\\{(.+?)\\}";
    
    
    private static String buildVariableRegex(String pretoken,String endtoken)
    {
        StringBuffer ret = new StringBuffer();
//        ret.append(pretoken).append("([^").append(endtoken).append("]+)").append(endtoken);
        ret.append(pretoken).append("(.+?)").append(endtoken);
        return ret.toString();
        
    }
    /**
     * ���Ը���Ĭ�ϵ�����ʽdefault_regex = "\\$\\{([^\\}]+)\\}"��ȡ���봮�еı�������Ϊ���鷵��
     * @param inputString
     * @return
     */
    public static String[] variableParser(String inputString)
    {
        String[] vars = RegexUtil.containWithPatternMatcherInput(inputString, default_regex);
        return vars;
    }
    
    /**
     * ���Ը���ָ���ı�����ǰ�����ͺ󵼷���ȡ���봮�еı�������Ϊ���鷵��
     * @param inputString
     * @param pretoken
     * @param endtoken
     * @return
     */
    public static String[] variableParser(String inputString,String pretoken,String endtoken)
    {
//        String regex = buildVariableRegex(pretoken,endtoken);   
//        String[] vars = RegexUtil.containWithPatternMatcherInput(inputString, regex);
//        return vars;
    	return variableParser( inputString,pretoken,endtoken,RegexUtil.default_mask);
    }
    
    /**
     * ���Ը���ָ���ı�����ǰ�����ͺ󵼷���ȡ���봮�еı�������Ϊ���鷵��
     * @param inputString
     * @param pretoken
     * @param endtoken
     * @return
     */
    public static String[] variableParser(String inputString,String pretoken,String endtoken,int mask)
    {
        String regex = buildVariableRegex(pretoken,endtoken);   
        String[] vars = RegexUtil.containWithPatternMatcherInput(inputString, regex,mask);
        return vars;
    }
    
    /**
     * ���Ը���ָ��������ʽ��ȡ���봮�еı�������Ϊ���鷵��
     * @param inputString
     * @param regex
     * @return
     */
    public static String[] variableParser(String inputString,String regex)
    {
//        String regex = buildVariableRegex(pretoken,endtoken);   
        String[] vars = RegexUtil.containWithPatternMatcherInput(inputString, regex);
        return vars;
    }
    /**
     * �Ӵ�src����ȡƥ��regexģʽ�������ַ�����������substitution�滻ƥ����ģʽ���ӷ���
     * @param src
     * @param regex
     * @param substitution
     * @return String[][]��ά���飬��һά��ʾ�滻���src���ڶ�ά��ʾƥ��regex�����е��Ӵ�����
     */
    public static String[][] parser2ndSubstitution(String inputString,String regex,String substitution)
    {
        return RegexUtil.contain2ndReplaceWithPatternMatcherInput(inputString, regex, substitution);
    }
    
    /**
     * �Ӵ�src����ȡƥ��regexģʽ�������ַ�����������substitution�滻ƥ����ģʽ���ӷ���
     * @param src
     * @param regex
     * @param substitution
     * @return String[][]��ά���飬��һά��ʾ�滻���src���ڶ�ά��ʾƥ��regex�����е��Ӵ�����
     */
    public static String[][] parser2ndSubstitution(String inputString,String substitution)
    {
        return RegexUtil.contain2ndReplaceWithPatternMatcherInput(inputString,default_regex , substitution);
    }
    
    
    /**
     * �Ӵ�src����ȡƥ��pretoken ��������ǰ׺��endtoken ���������׺ָ��ģʽ�����ַ�����������substitution�滻ƥ����ģʽ���ӷ���
     * @param inputString ����Ĵ� 
     * @param pretoken ��������ǰ׺
     * @param endtoken ���������׺
     * @param substitution
     * @return String[][]��ά���飬��һά��ʾ�滻���src���ڶ�ά��ʾƥ��regex�����е��Ӵ�����
     */
    public static String[][] parser2ndSubstitution(String inputString,String pretoken,String endtoken ,String substitution)
    {
        String regex = buildVariableRegex(pretoken,endtoken);  
        return RegexUtil.contain2ndReplaceWithPatternMatcherInput(inputString, regex, substitution,RegexUtil.default_mask);
    }
    
    /**
     * �Ӵ�src����ȡƥ��pretoken ��������ǰ׺��endtoken ���������׺ָ��ģʽ�����ַ�����������substitution�滻ƥ����ģʽ���ӷ���
     * @param inputString ����Ĵ� 
     * @param pretoken ��������ǰ׺
     * @param endtoken ���������׺
     * @param substitution
     * @return String[][]��ά���飬��һά��ʾ�滻���src���ڶ�ά��ʾƥ��regex�����е��Ӵ�����
     */
    public static String[][] parser2ndSubstitution(String inputString,String pretoken,String endtoken ,String substitution,int mask)
    {
        String regex = buildVariableRegex(pretoken,endtoken);  
        return RegexUtil.contain2ndReplaceWithPatternMatcherInput(inputString, regex, substitution,mask);
    }
    
    /**
     * �滻����Ϊ�ƶ���ֵ
     * @param inputString
     * @param substitution
     * @return
     */
    public static String substitution(String inputString,String substitution)
    {
    	return SimpleStringUtil.replaceAll(inputString, default_regex, substitution);
        
    }
    
    /**
     * �滻����Ϊ�ƶ���ֵ
     * @param inputString
     * @param substitution
     * @return
     */
    public static String substitution(String inputString,String regex,String substitution)
    {
    	return SimpleStringUtil.replaceAll(inputString, regex, substitution);
    }
    
    public static class URLStruction {
		private List<String> tokens;
		private List<Variable> variables;

		public List<String> getTokens() {
			return tokens;
		}

		public void setTokens(List<String> tokens) {
			this.tokens = tokens;
		}

		public List<Variable> getVariables() {
			return variables;
		}

		public void setVariables(List<Variable> variables) {
			this.variables = variables;
		}

	}

	public static class Variable {
		private String variableName;
		private int position;
		private List<Index> indexs;
		
		private Variable parent;
		private Variable next;
		public String getVariableName() {
			return variableName;
		}

		public void setVariableName(String variableName) {
			this.variableName = variableName;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public List<Index> getIndexs() {
			return indexs;
		}

		public void setIndexs(List<Index> indexs) {
			this.indexs = indexs;
		}

		public Variable getParent() {
			return parent;
		}

		public void setParent(Variable parent) {
			this.parent = parent;
		}

		public Variable getNext() {
			return next;
		}

		public void setNext(Variable next) {
			this.next = next;
		}
		

		
	}
	
	public static class Index
	{
//		private Object index;
		private int int_idx = -1;
		private String string_idx;
		public Index(int index) {
			super();
			this.int_idx = index;
			
		}
		public Index(String index) {
			super();
			this.string_idx = index;
			
		}
		
		public int getInt_idx() {
			return int_idx;
		}
		public String getString_idx() {
			return string_idx;
		}
	}
	
	
    
    /**
     * ������������url·�������ɳ����ַ����б��ͱ������������б�
     * �����ķֽ��Ϊ#[��],���url��û�а���������ô����nullֵ
     * @param url
     * @return
     */
    public static URLStruction parserURLStruction(String url) {
		if(url == null || url.trim().length() == 0)
			return null;
		int len = url.length();
		int i = 0;
		StringBuffer token = new StringBuffer();
		StringBuffer var = new StringBuffer();
		boolean varstart = false;
		int varstartposition = -1;

		List<Variable> variables = new ArrayList<Variable>();
		int varcount = 0;
		List<String> tokens = new ArrayList<String>();
		while (i < len) {
			if (url.charAt(i) == '#') {
				if(i + 1 < len)
				{
					if( url.charAt(i + 1) == '[')
					{
				
						if (varstart) {
							token.append("#[").append(var);
							var.setLength(0);
						}
		
						varstart = true;
		
						i = i + 2;
		
						varstartposition = i;
						var.setLength(0);
						continue;
					}
					
				}
				
			}

			if (varstart) {
				if (url.charAt(i) == '&') {
					varstart = false;
					i++;
					token.append("#[").append(var);
					var.setLength(0);
					continue;
				} else if (url.charAt(i) == ']') {
					if (i == varstartposition) {
						varstart = false;
						i++;
						token.append("#[]");
						continue;
					} else {
						Variable variable = new Variable();
						variable.setPosition(varcount);
						variable.setVariableName(var.toString());
						variables.add(variable);
						tokens.add(token.toString());
						token.setLength(0);
						var.setLength(0);
						varcount++;
						varstart = false;
						i++;
					}
				} else {
					var.append(url.charAt(i));
					i ++;
				}

			} else {
				token.append(url.charAt(i));
				i ++;
			}
		}
		if (token.length() > 0) {
			if (var.length() > 0) {
				token.append("#[").append(var);
			}
			tokens.add(token.toString());
		} else {
			if (var.length() > 0) {
//				token.append("#[").append(var);
//				tokens.add(token.toString());
				token.append("#[").append(var);
				int idx = tokens.size() - 1;
				tokens.set(idx,tokens.get(idx)+token.toString());
			}

		}

		if (variables.size() == 0)
			return null;
		else {
			URLStruction itemUrlStruction = new URLStruction();
			itemUrlStruction.setTokens(tokens);
			itemUrlStruction.setVariables(variables);
			return itemUrlStruction;
		}

	}
    
    
    /**
     * ������������sql�������ɳ����ַ����б��ͱ������������б�
     * �����ķֽ��Ϊ#[��],���url��û�а���������ô����nullֵ
     * �������顢list��map��Ԫ��ȡֵ����[]��������±��key����
     * �������ò���->���ӷ�
     * @param url
     * @return
     */
    public static URLStruction parserSQLStruction(String sql) {
		if(sql == null || sql.trim().length() == 0)
			return null;
		int len = sql.length();
		int i = 0;
		StringBuffer token = new StringBuffer();
		StringBuffer var = new StringBuffer();
//		StringBuffer index = new StringBuffer();
		
		boolean varstart = false;
		int varstartposition = -1;//��¼�����Ŀ�ʼλ��
		//����������ʼ
		boolean index_start = false;
		Variable header = null;
		Variable hh = null;
		Variable variable = null;
		List<Index> indexs = null;
		/**
		 * ������������λ�ÿ�ʼ
		 */
		boolean ref_start = false;

		List<Variable> variables = new ArrayList<Variable>();
		int varcount = 0;
		List<String> tokens = new ArrayList<String>();
		while (i < len) {
			if (sql.charAt(i) == '#') {
				if(i + 1 < len)
				{
					if( sql.charAt(i + 1) == '[')
					{
				
						if (varstart) {//fixed me
							String partvar = sql.substring(varstartposition,i);
//							token.append("#[").append(var);							
							token.append("#[").append(partvar);
							var.setLength(0);
						}
						index_start = false;
						varstart = true;
						variable = null;
						header = null;
						header = null;
						hh = null;
						indexs = null;
						/**
						 * ������������λ�ÿ�ʼ
						 */
						ref_start = false;
						i = i + 2;
		
						varstartposition = i;
						var.setLength(0);
						continue;
					}
					
				}
				
			}

			if (varstart) {
				if (sql.charAt(i) == '[') {
					
					if(!ref_start)
					{				
						if(!index_start)
						{
							header = new Variable();
							header.setPosition(varcount);
							header.setVariableName(var.toString());
//							variables.add(header);
							var.setLength(0);
							tokens.add(token.toString());
							token.setLength(0);
							varcount++;
							index_start = true;
							indexs = new ArrayList<Index>();
							header.setIndexs(indexs);
							hh = header;
						}
						else
						{
							//]
						}
						
					}
					else
					{
						if(!index_start)
						{
							variable = new Variable();
							//variable.setPosition(varcount);
							variable.setVariableName(var.toString());
							var.setLength(0);
							header.setNext(variable);
							header = variable;
							index_start = true;
							indexs = new ArrayList<Index>();
							header.setIndexs(indexs);
						}
					}
					i++;
//					token.append("#[").append(var);
					var.setLength(0);
					continue;
				} else if (sql.charAt(i) == ']') {
					if (i == varstartposition) {
						varstart = false;
						i++;
						token.append("#[]");
						continue;
					} else {
						if(index_start)
						{
						
							String t = var.toString();
							try{
								int idx = Integer.parseInt(t);
								indexs.add(new Index(idx));
							}
							catch(Exception e)
							{
								indexs.add(new Index(t));
							}
							var.setLength(0);
//							index_start = false;
							if(i + 1 < len)
							{
								if(sql.charAt(i + 1) == ']')
								{
									index_start = false;
									indexs = null;
//									i ++;
								}
							}
							i++;
							
						}
						else if(ref_start)//���ý����������������a->b[0]
						{
							ref_start = false;
//							if(sql.charAt(i + 1) == '-' && sql.charAt(i + 2) == '>')
//							{
//								
//							}
//							else
							{
								varstart = false;
							}
//							tokens.add(token.toString());
//							token.setLength(0);
							varcount++;
							if(variable == null)
							{
								variable = new Variable();
								//variable.setPosition(varcount);
								variable.setVariableName(var.toString());
								var.setLength(0);
								header.setNext(variable);
								header = variable;
							}
							variables.add(hh);	
							hh = null;
							i++;
						}
						else if(varstart)
						{
							if(header == null)
							{
								header = new Variable();
								header.setPosition(varcount);
								header.setVariableName(var.toString());
//								variables.add(header);								
								var.setLength(0);
								tokens.add(token.toString());
								token.setLength(0);
								varcount++;
								hh = header;
							}							
							varstart = false;
							variables.add(hh);	
							hh = null;
							i++;
						}
					}
				}
				else if (sql.charAt(i) == '-')
				{
					if(i + 1 < len )
					{
						if(sql.charAt(i+1) == '>')
						{
							if(varstart)
							{
								if(!ref_start)
								{
									ref_start = true;
									header = new Variable();
									header.setPosition(varcount);
									header.setVariableName(var.toString());
//									variables.add(header);
									var.setLength(0);
									//fixed
									tokens.add(token.toString());
									token.setLength(0);
									varcount++;
									hh = header;
								}
								else
								{
									if(variable == null)//û����Ϊ�����±굼�����ö����Ѿ���������ʼ��������
									{
										variable = new Variable();
										//variable.setPosition(varcount);
										variable.setVariableName(var.toString());
										var.setLength(0);
										indexs = null;
										header.setNext(variable);
										header = variable;
									}
									else
									{
										if(var.length() > 0)
										{
											variable = new Variable();
											//variable.setPosition(varcount);
											variable.setVariableName(var.toString());
											var.setLength(0);
											indexs = null;
											header.setNext(variable);
											header = variable;
										}
									}
								}
								index_start = false;
								indexs = null;
							}
							else
							{
								token.append("->");
							}
							i++;
							i++;
							continue;
						}
						else
						{
							var.append(sql.charAt(i)); 
							i ++;
						}
					}
				}
				else {
					var.append(sql.charAt(i)); 
					i ++;
				}

			} else {
				token.append(sql.charAt(i));
				i ++;
			}
		}
		/**
		 * �ݴ�������
		 * ���1.����û����ȫ����(��Ҫ��תheader����)
		 * ���2.������ַ���û�б���
		 * a.��ȫû�б�������عؼ���
		 * b.�в��ֱ������壬���ǲ�ȫ
		 * 
		 */
		if (token.length() > 0) {//���2.������ַ���û�б���
			if (var.length() > 0) {// b.�в��ֱ������壬���ǲ�ȫ���ӱ�����ʼ��λ�ûָ�token
				String partvar = sql.substring(varstartposition);
				token.append("#[").append(partvar);
//				token.append("#[").append(var);
			}
			tokens.add(token.toString());
		} 
		
		else {
			if (var.length() > 0) {//���1.����û����ȫ�������ӱ�����ʼ��λ�ûָ�token
//				token.append("#[").append(var);
				String partvar = sql.substring(varstartposition);
				token.append("#[").append(partvar);
				int idx = tokens.size() - 1;
				tokens.set(idx, tokens.get(idx) + token.toString());
//				tokens.add(token.toString());
			}

		}

		if (variables.size() == 0)
			return null;
		else {
			URLStruction itemUrlStruction = new URLStruction();
			itemUrlStruction.setTokens(tokens);
			itemUrlStruction.setVariables(variables);
			return itemUrlStruction;
		}

	}
    
    public static void testUrlParser()
    {
    	String url = "http://localhost:80/detail.html?user=#[account[0][0]]&password=#[password->aaa[0]->bb->cc[0]]love";
        URLStruction a = parserURLStruction(url);
		 url =
		 "http://localhost:80/detail.html?user=#[account&password=password]&love=#[account[key]]";
		 a = parserURLStruction(url);
		 url =
			 "http://localhost:80/detail.html?user=#[account&password=password]&love=#[account";
//		 
		 a = parserURLStruction(url);
		 url =
			 "http://localhost:80/detail.html?user=#[account&password=#[password&love=#[account";
		 a = parserURLStruction(url);
//		 url =
//			 "http://localhost:80/detail.html";
//		 
//		 url =
//			 "http://localhost:80/#[]detail.html";
//		 url =
//			 "#[account";
		 System.out.println("url:"+url);
		// Item item = new Item();
		
		// Map<String,String> map = new HashMap<String, String>();
		// map.put("account", "aaa");
		// map.put("password", "123");
		// item.combinationItemUrlStruction(a, map);

		if(a != null){
			
		
		List<String> tokens = a.getTokens();
		for (int k = 0; k < tokens.size(); k++) {
			System.out.println("tokens[" + k + "]:" + tokens.get(k));
		}
		List<Variable> variables = a.getVariables();

		for (int k = 0; k < variables.size(); k++) {

			Variable as = variables.get(k);

			System.out.println("�������ƣ�" + as.getVariableName());
			System.out.println("������Ӧλ�ã�" + as.getPosition());

		}
		}
    }
    public static void testSQLParser()
    {
    	 String url = "http://localhost:80/detail.html?user=#[account[0][0]]&password=#[password->aaa[0]->bb->cc[0]]love";
         URLStruction a = parserSQLStruction(url);
 		 url =
 		 "http://localhost:80/detail.html?user=#[account]&password=#[password]&love=#[account[key]]";
 		 a = parserSQLStruction(url);
 		url =
 	 		 "http://localhost:80/detail.html?user=#[account]&password=#[password]&love=#[account[0";
 	 		 a = parserSQLStruction(url);
 	 		 
 	 		url =
 	 	 		 "http://localhost:80/detail.html?user=account&password=password&love=account";
 	 	 		 a = parserSQLStruction(url);
 	 	 		url =
 	 	 	 		 "http://localhost:80/detail.html?user=account&password=password]&love=account]";
 	 	 	 		 a = parserSQLStruction(url);
 		 url =
 			 "http://localhost:80/detail.html,user=#[account],password=#[password],account=#[account]";
 		 a = parserSQLStruction(url);
 		 
 		 url =
 			 "http://localhost:80/#[detail.html,user=#[account],password=#[password],account=#[account]";
 		 a = parserSQLStruction(url);
// 		 url =
// 			 "http://localhost:80/detail.html";
// 		 
// 		 url =
// 			 "http://localhost:80/#[]detail.html";
// 		 url =
// 			 "#[account";
 		 System.out.println("url:"+url);
 		// Item item = new Item();
 		
 		// Map<String,String> map = new HashMap<String, String>();
 		// map.put("account", "aaa");
 		// map.put("password", "123");
 		// item.combinationItemUrlStruction(a, map);

 		if(a != null){
 			
 		
	 		List<String> tokens = a.getTokens();
	 		for (int k = 0; k < tokens.size(); k++) {
	 			System.out.println("tokens[" + k + "]:" + tokens.get(k));
	 		}
	 		List<Variable> variables = a.getVariables();
	
	 		for (int k = 0; k < variables.size(); k++) {
	
	 			Variable as = variables.get(k);
	
	 			System.out.println("�������ƣ�" + as.getVariableName());
	 			System.out.println("������Ӧλ�ã�" + as.getPosition());
	 			//��������Ƕ�Ӧ���������list��set��map��Ԫ�ص�Ӧ�ã��������Ӧ��Ԫ�������±���Ϣ
	 			List<Index> idxs = as.getIndexs();
	 			if(idxs != null)
	 			{
	 				for(int h = 0; h < idxs.size(); h ++)
	 				{
	 					Index idx = idxs.get(h);
	 					if(idx.getInt_idx() > 0)
	 					{
	 						System.out.println("Ԫ�������±꣺"+idx.getInt_idx());
	 					}
	 					else
	 					{
	 						System.out.println("map key��"+idx.getString_idx());
	 					}
	 				}
	 			}
	
	 		}
 		}
    }
    public static void main(String[] args)
    {
    	testSQLParser();
        
        
        
        
    }
    
    
}