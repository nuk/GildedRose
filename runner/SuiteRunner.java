import gildedrose.console.HotelConsole;
import gildedrose.console.HotelConsoleFactory;
import gildedrose.console.HotelConsoleTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDException;
import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleSet;
import net.sourceforge.pmd.RuleSets;
import net.sourceforge.pmd.SourceType;
import net.sourceforge.pmd.ast.ParseException;
import net.sourceforge.pmd.rules.AccessorClassGeneration;
import net.sourceforge.pmd.rules.AssignmentInOperand;
import net.sourceforge.pmd.rules.AvoidCallingFinalize;
import net.sourceforge.pmd.rules.AvoidDeeplyNestedIfStmtsRule;
import net.sourceforge.pmd.rules.AvoidFieldNameMatchingMethodName;
import net.sourceforge.pmd.rules.AvoidFieldNameMatchingTypeName;
import net.sourceforge.pmd.rules.AvoidNonConstructorMethodsWithClassName;
import net.sourceforge.pmd.rules.AvoidReassigningParameters;
import net.sourceforge.pmd.rules.ClassNamingConventions;
import net.sourceforge.pmd.rules.CloseResource;
import net.sourceforge.pmd.rules.ConstructorCallsOverridableMethod;
import net.sourceforge.pmd.rules.CouplingBetweenObjects;
import net.sourceforge.pmd.rules.DoubleCheckedLocking;
import net.sourceforge.pmd.rules.ExcessiveImports;
import net.sourceforge.pmd.rules.ExcessivePublicCount;
import net.sourceforge.pmd.rules.IdempotentOperations;
import net.sourceforge.pmd.rules.MethodNamingConventions;
import net.sourceforge.pmd.rules.MethodWithSameNameAsEnclosingClass;
import net.sourceforge.pmd.rules.MoreThanOneLogger;
import net.sourceforge.pmd.rules.OverrideBothEqualsAndHashcode;
import net.sourceforge.pmd.rules.SimplifyBooleanReturns;
import net.sourceforge.pmd.rules.StringConcatenationRule;
import net.sourceforge.pmd.rules.SuspiciousOctalEscape;
import net.sourceforge.pmd.rules.SymbolTableTestRule;
import net.sourceforge.pmd.rules.UnnecessaryConversionTemporary;
import net.sourceforge.pmd.rules.UnusedFormalParameterRule;
import net.sourceforge.pmd.rules.UnusedLocalVariableRule;
import net.sourceforge.pmd.rules.UnusedModifier;
import net.sourceforge.pmd.rules.UnusedPrivateFieldRule;
import net.sourceforge.pmd.rules.UnusedPrivateMethodRule;
import net.sourceforge.pmd.rules.UselessOperationOnImmutable;
import net.sourceforge.pmd.rules.UselessOverridingMethod;
import net.sourceforge.pmd.rules.VariableNamingConventions;
import net.sourceforge.pmd.rules.basic.AvoidMultipleUnaryOperators;
import net.sourceforge.pmd.rules.basic.AvoidUsingHardCodedIP;
import net.sourceforge.pmd.rules.basic.AvoidUsingOctalValues;
import net.sourceforge.pmd.rules.basic.BigIntegerInstantiation;
import net.sourceforge.pmd.rules.basic.BooleanInstantiation;
import net.sourceforge.pmd.rules.basic.BrokenNullCheck;
import net.sourceforge.pmd.rules.basic.UnnecessaryReturn;
import net.sourceforge.pmd.rules.design.AssignmentToNonFinalStatic;
import net.sourceforge.pmd.rules.design.CompareObjectsWithEquals;
import net.sourceforge.pmd.rules.design.ConfusingTernary;
import net.sourceforge.pmd.rules.design.ExceptionAsFlowControl;
import net.sourceforge.pmd.rules.design.LongClassRule;
import net.sourceforge.pmd.rules.design.LongMethodRule;
import net.sourceforge.pmd.rules.design.LongParameterListRule;
import net.sourceforge.pmd.rules.design.LooseCoupling;
import net.sourceforge.pmd.rules.design.NonThreadSafeSingleton;
import net.sourceforge.pmd.rules.design.NullAssignmentRule;
import net.sourceforge.pmd.rules.design.OnlyOneReturnRule;
import net.sourceforge.pmd.rules.design.PositionalIteratorRule;
import net.sourceforge.pmd.rules.design.PreserveStackTrace;
import net.sourceforge.pmd.rules.design.SingularField;
import net.sourceforge.pmd.rules.design.SwitchDensityRule;
import net.sourceforge.pmd.rules.design.TooManyFields;
import net.sourceforge.pmd.rules.design.UnnecessaryLocalBeforeReturn;
import net.sourceforge.pmd.rules.design.UnsynchronizedStaticDateFormatter;
import net.sourceforge.pmd.rules.design.UseCollectionIsEmpty;
import net.sourceforge.pmd.rules.design.UseSingleton;
import net.sourceforge.pmd.rules.imports.DontImportJavaLang;
import net.sourceforge.pmd.rules.imports.DontImportSun;
import net.sourceforge.pmd.rules.imports.DuplicateImportsRule;
import net.sourceforge.pmd.rules.imports.ImportFromSamePackageRule;
import net.sourceforge.pmd.rules.imports.UnusedImportsRule;
import net.sourceforge.pmd.rules.junit.JUnitAssertionsShouldIncludeMessage;
import net.sourceforge.pmd.rules.junit.JUnitTestsShouldContainAsserts;
import net.sourceforge.pmd.rules.junit.TestClassWithoutTestCases;
import net.sourceforge.pmd.rules.migration.JUnitUseExpected;
import net.sourceforge.pmd.rules.naming.AvoidDollarSigns;
import net.sourceforge.pmd.rules.naming.SuspiciousHashcodeMethodName;
import net.sourceforge.pmd.rules.optimization.AbstractOptimizationRule;
import net.sourceforge.pmd.rules.optimization.AvoidInstantiatingObjectsInLoops;
import net.sourceforge.pmd.rules.optimization.LocalVariableCouldBeFinal;
import net.sourceforge.pmd.rules.optimization.UnnecessaryWrapperObjectCreation;
import net.sourceforge.pmd.rules.optimization.UseStringBufferForStringAppends;
import net.sourceforge.pmd.rules.strictexception.AvoidCatchingThrowable;
import net.sourceforge.pmd.rules.strictexception.ExceptionSignatureDeclaration;
import net.sourceforge.pmd.rules.strings.AppendCharacterWithChar;
import net.sourceforge.pmd.rules.strings.ConsecutiveLiteralAppends;
import net.sourceforge.pmd.rules.strings.InefficientEmptyStringCheck;
import net.sourceforge.pmd.rules.strings.InefficientStringBuffering;
import net.sourceforge.pmd.rules.strings.InsufficientStringBufferDeclaration;
import net.sourceforge.pmd.rules.strings.StringInstantiation;
import net.sourceforge.pmd.rules.strings.StringToStringRule;
import net.sourceforge.pmd.rules.strings.UnnecessaryCaseChange;
import net.sourceforge.pmd.rules.strings.UseIndexOfChar;
import net.sourceforge.pmd.rules.strings.UseStringBufferLength;
import net.sourceforge.pmd.rules.strings.UselessStringValueOf;
import net.sourceforge.pmd.rules.sunsecure.ArrayIsStoredDirectly;
import net.sourceforge.pmd.rules.sunsecure.MethodReturnsInternalArray;


public class SuiteRunner {

	private static class Result{
		String test_name;
		long junit_total_tests;
		long junit_failed_tests;
		long junit_total_time;
		long pmd_score;
	}
	
	public static void main(String[] args) throws ParseException, FileNotFoundException, PMDException {
		Class[] hotelClasses = new Class[]{HotelConsole.class, EmptyHotelConsole.class};
		List<Result> results = new ArrayList<Result>();
		for (Class c : hotelClasses){
			HotelConsoleFactory.setHotelConsoleClass(c);
			Result result = process();
			result.test_name = c.getName();
			results.add(result);
		}
		generateOutput(results);
	}

	private static Result process() throws PMDException, FileNotFoundException {
		Result result = new Result();
		processTests(result);
		processPMD(result);
		return result;
	}

	private static void generateOutput(List<Result> results) {
		System.out.println("Name\tTests\tFailed\tTime\tViolations");
		for (Result result : results){
			StringBuffer sb = new StringBuffer();
			sb.append(result.test_name);
			sb.append('\t');
			sb.append(result.junit_total_tests);
			sb.append('\t');
			sb.append(result.junit_failed_tests);
			sb.append('\t');
			sb.append(result.junit_total_time);
			sb.append('\t');
			sb.append(result.pmd_score);
			System.out.println(sb.toString());
		}
	}

	private static void processPMD(Result result) throws PMDException, FileNotFoundException {
		String file = "/media/Dados/coding/GildedRose/src/gildedrose/console/HotelConsole.java";
		
		PMD pmd = new PMD();
		RuleContext ruleContext = new RuleContext();
		Report report = new Report();
		ruleContext.setSourceCodeFilename("HotelConsole.java");
		ruleContext.setReport(report);
		pmd.processFile(new FileReader(file), createRuleSet(), ruleContext, SourceType.JAVA_16);
		
		long sum = 0;
		for (Integer i : report.getCountSummary().values())	{	sum+= i;}
		for (Integer i : report.getSummary().values())		{	sum+= i;}
		
		result.pmd_score = sum;
	}

	private static void processTests(Result result) {
		org.junit.runner.Result r = org.junit.runner.JUnitCore.runClasses(HotelConsoleTest.class);
		result.junit_failed_tests = r.getFailureCount();
		result.junit_total_tests = r.getRunCount();
		result.junit_total_time = r.getRunTime();
		
	}

	private static RuleSets createRuleSet() {
		RuleSets ruleSets = new RuleSets();
		RuleSet set = new RuleSet();
		
		set.addRule( new AccessorClassGeneration ());
		set.addRule( new AssignmentInOperand ());
		set.addRule( new AvoidCallingFinalize ());
		set.addRule( new AvoidDeeplyNestedIfStmtsRule ());
		set.addRule( new AvoidFieldNameMatchingMethodName ());
		set.addRule( new AvoidFieldNameMatchingTypeName ());
		set.addRule( new AvoidNonConstructorMethodsWithClassName ());
		set.addRule( new AvoidReassigningParameters ());
		//set.addRule( new BeanMembersShouldSerializeRule ());
		set.addRule( new ClassNamingConventions ());
		set.addRule( new CloseResource ());
		set.addRule( new ConstructorCallsOverridableMethod ());
		set.addRule( new CouplingBetweenObjects ());
		//set.addRule( new CyclomaticComplexity ());
		set.addRule( new DoubleCheckedLocking ());
		set.addRule( new ExcessiveImports ());
		set.addRule( new ExcessivePublicCount ());
		//set.addRule( new GenericLiteralCheckerRule ());
		set.addRule( new IdempotentOperations ());
		set.addRule( new MethodNamingConventions ());
		set.addRule( new MethodWithSameNameAsEnclosingClass ());
		set.addRule( new MoreThanOneLogger ());
		set.addRule( new OverrideBothEqualsAndHashcode ());
		set.addRule( new SimplifyBooleanReturns ());
		set.addRule( new StringConcatenationRule ());
		set.addRule( new SuspiciousOctalEscape ());
		set.addRule( new SymbolTableTestRule ());
		set.addRule( new UnnecessaryConversionTemporary ());
		set.addRule( new UnusedFormalParameterRule ());
		set.addRule( new UnusedLocalVariableRule ());
		set.addRule( new UnusedModifier ());
		set.addRule( new UnusedPrivateFieldRule ());
		set.addRule( new UnusedPrivateMethodRule ());
		//set.addRule( new UselessAssignment ());
		set.addRule( new UselessOperationOnImmutable ());
		set.addRule( new UselessOverridingMethod ());
		set.addRule( new VariableNamingConventions ());
		//set.addRule( new XPathRule());
		set.addRule( new AvoidMultipleUnaryOperators ());
		set.addRule( new AvoidUsingHardCodedIP ());
		set.addRule( new AvoidUsingOctalValues ());
		set.addRule( new BigIntegerInstantiation ());
		set.addRule( new BooleanInstantiation ());
		set.addRule( new BrokenNullCheck ());
		set.addRule( new UnnecessaryReturn());
		//set.addRule( new NcssConstructorCount ());
		//set.addRule( new NcssMethodCount ());
		//set.addRule( new NcssTypeCount());
		set.addRule( new AssignmentToNonFinalStatic ());
		set.addRule( new CompareObjectsWithEquals ());
		set.addRule( new ConfusingTernary ());
		set.addRule( new ExceptionAsFlowControl ());
		//set.addRule( new GenericClassCounterRule ());
		//set.addRule( new ImmutableField ());
		set.addRule( new LongClassRule ());
		set.addRule( new LongMethodRule ());
		set.addRule( new LongParameterListRule ());
		set.addRule( new LooseCoupling ());
		set.addRule( new NonThreadSafeSingleton ());
		//set.addRule( new NpathComplexity ());
		set.addRule( new NullAssignmentRule ());
		set.addRule( new OnlyOneReturnRule ());
		set.addRule( new PositionalIteratorRule ());
		set.addRule( new PreserveStackTrace ());
		set.addRule( new SingularField ());
		set.addRule( new SwitchDensityRule ());
		set.addRule( new TooManyFields ());
		set.addRule( new UnnecessaryLocalBeforeReturn ());
		set.addRule( new UnsynchronizedStaticDateFormatter ());
		set.addRule( new UseCollectionIsEmpty ());
		set.addRule( new UseSingleton());
		set.addRule( new DontImportJavaLang ());
		set.addRule( new DontImportSun ());
		set.addRule( new DuplicateImportsRule ());
		set.addRule( new ImportFromSamePackageRule ());
		set.addRule( new UnusedImportsRule());
		set.addRule( new JUnitAssertionsShouldIncludeMessage ());
		set.addRule( new JUnitTestsShouldContainAsserts ());
		set.addRule( new TestClassWithoutTestCases());
		set.addRule( new JUnitUseExpected ());
		//set.addRule( new UnnecessaryCast());
		set.addRule( new AvoidDollarSigns ());
		set.addRule( new SuspiciousHashcodeMethodName());
		set.addRule( new AbstractOptimizationRule ());
		set.addRule( new AvoidInstantiatingObjectsInLoops ());
		set.addRule( new LocalVariableCouldBeFinal ());
		//set.addRule( new MethodArgumentCouldBeFinal ());
		set.addRule( new UnnecessaryWrapperObjectCreation ());
		set.addRule( new UseStringBufferForStringAppends());
		set.addRule( new AvoidCatchingThrowable ());
		set.addRule( new ExceptionSignatureDeclaration());
		set.addRule( new AppendCharacterWithChar ());
		//set.addRule( new AvoidDuplicateLiteralsRule ());
		set.addRule( new ConsecutiveLiteralAppends ());
		set.addRule( new InefficientEmptyStringCheck ());
		set.addRule( new InefficientStringBuffering ());
		set.addRule( new InsufficientStringBufferDeclaration ());
		set.addRule( new StringInstantiation ());
		set.addRule( new StringToStringRule ());
		set.addRule( new UnnecessaryCaseChange ());
		set.addRule( new UseIndexOfChar ());
		set.addRule( new UselessStringValueOf ());
		set.addRule( new UseStringBufferLength());
		set.addRule( new ArrayIsStoredDirectly ());
		set.addRule( new MethodReturnsInternalArray());
		
		ruleSets.addRuleSet(set);
		return ruleSets;
	}

	
}
