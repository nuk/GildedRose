import gildedrose.console.HotelConsoleTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDException;
import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleSet;
import net.sourceforge.pmd.RuleSets;
import net.sourceforge.pmd.SourceType;
import net.sourceforge.pmd.ast.ParseException;
import net.sourceforge.pmd.rules.*;
import net.sourceforge.pmd.rules.basic.*;
import net.sourceforge.pmd.rules.design.*;
import net.sourceforge.pmd.rules.imports.*;
import net.sourceforge.pmd.rules.junit.*;
import net.sourceforge.pmd.rules.migration.JUnitUseExpected;
import net.sourceforge.pmd.rules.naming.*;
import net.sourceforge.pmd.rules.optimization.*;
import net.sourceforge.pmd.rules.strictexception.*;
import net.sourceforge.pmd.rules.strings.*;
import net.sourceforge.pmd.rules.sunsecure.*;
import net.sourceforge.pmd.stat.Metric;

import org.junit.runner.Result;


public class SuiteRunner {

	public static void main(String[] args) throws ParseException, FileNotFoundException, PMDException {
		Result result = org.junit.runner.JUnitCore.runClasses(HotelConsoleTest.class);
		System.out.println(result.getFailureCount());
		System.out.println(result.getRunCount());
		System.out.println(result.getRunTime());
		
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
		System.out.println(sum);
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
