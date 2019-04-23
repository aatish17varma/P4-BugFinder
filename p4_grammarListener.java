// Generated from p4_grammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link p4_grammarParser}.
 */
public interface p4_grammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#p4program}.
	 * @param ctx the parse tree
	 */
	void enterP4program(p4_grammarParser.P4programContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#p4program}.
	 * @param ctx the parse tree
	 */
	void exitP4program(p4_grammarParser.P4programContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(p4_grammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(p4_grammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#nonTypeName}.
	 * @param ctx the parse tree
	 */
	void enterNonTypeName(p4_grammarParser.NonTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#nonTypeName}.
	 * @param ctx the parse tree
	 */
	void exitNonTypeName(p4_grammarParser.NonTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(p4_grammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(p4_grammarParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#nonTableKwName}.
	 * @param ctx the parse tree
	 */
	void enterNonTableKwName(p4_grammarParser.NonTableKwNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#nonTableKwName}.
	 * @param ctx the parse tree
	 */
	void exitNonTableKwName(p4_grammarParser.NonTableKwNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#optAnnotations}.
	 * @param ctx the parse tree
	 */
	void enterOptAnnotations(p4_grammarParser.OptAnnotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#optAnnotations}.
	 * @param ctx the parse tree
	 */
	void exitOptAnnotations(p4_grammarParser.OptAnnotationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#annotations}.
	 * @param ctx the parse tree
	 */
	void enterAnnotations(p4_grammarParser.AnnotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#annotations}.
	 * @param ctx the parse tree
	 */
	void exitAnnotations(p4_grammarParser.AnnotationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(p4_grammarParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(p4_grammarParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(p4_grammarParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(p4_grammarParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#nonEmptyParameterList}.
	 * @param ctx the parse tree
	 */
	void enterNonEmptyParameterList(p4_grammarParser.NonEmptyParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#nonEmptyParameterList}.
	 * @param ctx the parse tree
	 */
	void exitNonEmptyParameterList(p4_grammarParser.NonEmptyParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(p4_grammarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(p4_grammarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(p4_grammarParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(p4_grammarParser.DirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#packageTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageTypeDeclaration(p4_grammarParser.PackageTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#packageTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageTypeDeclaration(p4_grammarParser.PackageTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(p4_grammarParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(p4_grammarParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#optConstructorParameters}.
	 * @param ctx the parse tree
	 */
	void enterOptConstructorParameters(p4_grammarParser.OptConstructorParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#optConstructorParameters}.
	 * @param ctx the parse tree
	 */
	void exitOptConstructorParameters(p4_grammarParser.OptConstructorParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#dotPrefix}.
	 * @param ctx the parse tree
	 */
	void enterDotPrefix(p4_grammarParser.DotPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#dotPrefix}.
	 * @param ctx the parse tree
	 */
	void exitDotPrefix(p4_grammarParser.DotPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParserDeclaration(p4_grammarParser.ParserDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParserDeclaration(p4_grammarParser.ParserDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserLocalElements}.
	 * @param ctx the parse tree
	 */
	void enterParserLocalElements(p4_grammarParser.ParserLocalElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserLocalElements}.
	 * @param ctx the parse tree
	 */
	void exitParserLocalElements(p4_grammarParser.ParserLocalElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserLocalElement}.
	 * @param ctx the parse tree
	 */
	void enterParserLocalElement(p4_grammarParser.ParserLocalElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserLocalElement}.
	 * @param ctx the parse tree
	 */
	void exitParserLocalElement(p4_grammarParser.ParserLocalElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParserTypeDeclaration(p4_grammarParser.ParserTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParserTypeDeclaration(p4_grammarParser.ParserTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserStates}.
	 * @param ctx the parse tree
	 */
	void enterParserStates(p4_grammarParser.ParserStatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserStates}.
	 * @param ctx the parse tree
	 */
	void exitParserStates(p4_grammarParser.ParserStatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserState}.
	 * @param ctx the parse tree
	 */
	void enterParserState(p4_grammarParser.ParserStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserState}.
	 * @param ctx the parse tree
	 */
	void exitParserState(p4_grammarParser.ParserStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserStatements}.
	 * @param ctx the parse tree
	 */
	void enterParserStatements(p4_grammarParser.ParserStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserStatements}.
	 * @param ctx the parse tree
	 */
	void exitParserStatements(p4_grammarParser.ParserStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserStatement}.
	 * @param ctx the parse tree
	 */
	void enterParserStatement(p4_grammarParser.ParserStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserStatement}.
	 * @param ctx the parse tree
	 */
	void exitParserStatement(p4_grammarParser.ParserStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#parserBlockStatement}.
	 * @param ctx the parse tree
	 */
	void enterParserBlockStatement(p4_grammarParser.ParserBlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#parserBlockStatement}.
	 * @param ctx the parse tree
	 */
	void exitParserBlockStatement(p4_grammarParser.ParserBlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#transitionStatement}.
	 * @param ctx the parse tree
	 */
	void enterTransitionStatement(p4_grammarParser.TransitionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#transitionStatement}.
	 * @param ctx the parse tree
	 */
	void exitTransitionStatement(p4_grammarParser.TransitionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#stateExpression}.
	 * @param ctx the parse tree
	 */
	void enterStateExpression(p4_grammarParser.StateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#stateExpression}.
	 * @param ctx the parse tree
	 */
	void exitStateExpression(p4_grammarParser.StateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#selectExpression}.
	 * @param ctx the parse tree
	 */
	void enterSelectExpression(p4_grammarParser.SelectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#selectExpression}.
	 * @param ctx the parse tree
	 */
	void exitSelectExpression(p4_grammarParser.SelectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#selectCaseList}.
	 * @param ctx the parse tree
	 */
	void enterSelectCaseList(p4_grammarParser.SelectCaseListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#selectCaseList}.
	 * @param ctx the parse tree
	 */
	void exitSelectCaseList(p4_grammarParser.SelectCaseListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#selectCase}.
	 * @param ctx the parse tree
	 */
	void enterSelectCase(p4_grammarParser.SelectCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#selectCase}.
	 * @param ctx the parse tree
	 */
	void exitSelectCase(p4_grammarParser.SelectCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#keysetExpression}.
	 * @param ctx the parse tree
	 */
	void enterKeysetExpression(p4_grammarParser.KeysetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#keysetExpression}.
	 * @param ctx the parse tree
	 */
	void exitKeysetExpression(p4_grammarParser.KeysetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#tupleKeysetExpression}.
	 * @param ctx the parse tree
	 */
	void enterTupleKeysetExpression(p4_grammarParser.TupleKeysetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#tupleKeysetExpression}.
	 * @param ctx the parse tree
	 */
	void exitTupleKeysetExpression(p4_grammarParser.TupleKeysetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#simpleExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpressionList(p4_grammarParser.SimpleExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#simpleExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpressionList(p4_grammarParser.SimpleExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#simpleKeysetExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleKeysetExpression(p4_grammarParser.SimpleKeysetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#simpleKeysetExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleKeysetExpression(p4_grammarParser.SimpleKeysetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#valueSetDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterValueSetDeclaration(p4_grammarParser.ValueSetDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#valueSetDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitValueSetDeclaration(p4_grammarParser.ValueSetDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#controlDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterControlDeclaration(p4_grammarParser.ControlDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#controlDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitControlDeclaration(p4_grammarParser.ControlDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#controlTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterControlTypeDeclaration(p4_grammarParser.ControlTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#controlTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitControlTypeDeclaration(p4_grammarParser.ControlTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#controlLocalDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterControlLocalDeclarations(p4_grammarParser.ControlLocalDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#controlLocalDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitControlLocalDeclarations(p4_grammarParser.ControlLocalDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#controlLocalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterControlLocalDeclaration(p4_grammarParser.ControlLocalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#controlLocalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitControlLocalDeclaration(p4_grammarParser.ControlLocalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#controlBody}.
	 * @param ctx the parse tree
	 */
	void enterControlBody(p4_grammarParser.ControlBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#controlBody}.
	 * @param ctx the parse tree
	 */
	void exitControlBody(p4_grammarParser.ControlBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#externDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExternDeclaration(p4_grammarParser.ExternDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#externDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExternDeclaration(p4_grammarParser.ExternDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#methodPrototypes}.
	 * @param ctx the parse tree
	 */
	void enterMethodPrototypes(p4_grammarParser.MethodPrototypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#methodPrototypes}.
	 * @param ctx the parse tree
	 */
	void exitMethodPrototypes(p4_grammarParser.MethodPrototypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#functionPrototype}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPrototype(p4_grammarParser.FunctionPrototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#functionPrototype}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPrototype(p4_grammarParser.FunctionPrototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#methodPrototype}.
	 * @param ctx the parse tree
	 */
	void enterMethodPrototype(p4_grammarParser.MethodPrototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#methodPrototype}.
	 * @param ctx the parse tree
	 */
	void exitMethodPrototype(p4_grammarParser.MethodPrototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(p4_grammarParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(p4_grammarParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#namedType}.
	 * @param ctx the parse tree
	 */
	void enterNamedType(p4_grammarParser.NamedTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#namedType}.
	 * @param ctx the parse tree
	 */
	void exitNamedType(p4_grammarParser.NamedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#prefixedType}.
	 * @param ctx the parse tree
	 */
	void enterPrefixedType(p4_grammarParser.PrefixedTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#prefixedType}.
	 * @param ctx the parse tree
	 */
	void exitPrefixedType(p4_grammarParser.PrefixedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(p4_grammarParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(p4_grammarParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#tupleType}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(p4_grammarParser.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#tupleType}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(p4_grammarParser.TupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#headerStackType}.
	 * @param ctx the parse tree
	 */
	void enterHeaderStackType(p4_grammarParser.HeaderStackTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#headerStackType}.
	 * @param ctx the parse tree
	 */
	void exitHeaderStackType(p4_grammarParser.HeaderStackTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#specializedType}.
	 * @param ctx the parse tree
	 */
	void enterSpecializedType(p4_grammarParser.SpecializedTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#specializedType}.
	 * @param ctx the parse tree
	 */
	void exitSpecializedType(p4_grammarParser.SpecializedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(p4_grammarParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(p4_grammarParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeOrVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypeOrVoid(p4_grammarParser.TypeOrVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeOrVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypeOrVoid(p4_grammarParser.TypeOrVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#optTypeParameters}.
	 * @param ctx the parse tree
	 */
	void enterOptTypeParameters(p4_grammarParser.OptTypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#optTypeParameters}.
	 * @param ctx the parse tree
	 */
	void exitOptTypeParameters(p4_grammarParser.OptTypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(p4_grammarParser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(p4_grammarParser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#realTypeArg}.
	 * @param ctx the parse tree
	 */
	void enterRealTypeArg(p4_grammarParser.RealTypeArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#realTypeArg}.
	 * @param ctx the parse tree
	 */
	void exitRealTypeArg(p4_grammarParser.RealTypeArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeArg}.
	 * @param ctx the parse tree
	 */
	void enterTypeArg(p4_grammarParser.TypeArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeArg}.
	 * @param ctx the parse tree
	 */
	void exitTypeArg(p4_grammarParser.TypeArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#realTypeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterRealTypeArgumentList(p4_grammarParser.RealTypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#realTypeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitRealTypeArgumentList(p4_grammarParser.RealTypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(p4_grammarParser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(p4_grammarParser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(p4_grammarParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(p4_grammarParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#derivedTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDerivedTypeDeclaration(p4_grammarParser.DerivedTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#derivedTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDerivedTypeDeclaration(p4_grammarParser.DerivedTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#headerTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterHeaderTypeDeclaration(p4_grammarParser.HeaderTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#headerTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitHeaderTypeDeclaration(p4_grammarParser.HeaderTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#headerUnionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterHeaderUnionDeclaration(p4_grammarParser.HeaderUnionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#headerUnionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitHeaderUnionDeclaration(p4_grammarParser.HeaderUnionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#structTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructTypeDeclaration(p4_grammarParser.StructTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#structTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructTypeDeclaration(p4_grammarParser.StructTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#structFieldList}.
	 * @param ctx the parse tree
	 */
	void enterStructFieldList(p4_grammarParser.StructFieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#structFieldList}.
	 * @param ctx the parse tree
	 */
	void exitStructFieldList(p4_grammarParser.StructFieldListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#structField}.
	 * @param ctx the parse tree
	 */
	void enterStructField(p4_grammarParser.StructFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#structField}.
	 * @param ctx the parse tree
	 */
	void exitStructField(p4_grammarParser.StructFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(p4_grammarParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(p4_grammarParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#errorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterErrorDeclaration(p4_grammarParser.ErrorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#errorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitErrorDeclaration(p4_grammarParser.ErrorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#matchKindDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMatchKindDeclaration(p4_grammarParser.MatchKindDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#matchKindDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMatchKindDeclaration(p4_grammarParser.MatchKindDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(p4_grammarParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(p4_grammarParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#specifiedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterSpecifiedIdentifierList(p4_grammarParser.SpecifiedIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#specifiedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitSpecifiedIdentifierList(p4_grammarParser.SpecifiedIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#specifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecifiedIdentifier(p4_grammarParser.SpecifiedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#specifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecifiedIdentifier(p4_grammarParser.SpecifiedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#typedefDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypedefDeclaration(p4_grammarParser.TypedefDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#typedefDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypedefDeclaration(p4_grammarParser.TypedefDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#assignmentOrMethodCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOrMethodCallStatement(p4_grammarParser.AssignmentOrMethodCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#assignmentOrMethodCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOrMethodCallStatement(p4_grammarParser.AssignmentOrMethodCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(p4_grammarParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(p4_grammarParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(p4_grammarParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(p4_grammarParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#exitStatement}.
	 * @param ctx the parse tree
	 */
	void enterExitStatement(p4_grammarParser.ExitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#exitStatement}.
	 * @param ctx the parse tree
	 */
	void exitExitStatement(p4_grammarParser.ExitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(p4_grammarParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(p4_grammarParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#directApplication}.
	 * @param ctx the parse tree
	 */
	void enterDirectApplication(p4_grammarParser.DirectApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#directApplication}.
	 * @param ctx the parse tree
	 */
	void exitDirectApplication(p4_grammarParser.DirectApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(p4_grammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(p4_grammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(p4_grammarParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(p4_grammarParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#statOrDeclList}.
	 * @param ctx the parse tree
	 */
	void enterStatOrDeclList(p4_grammarParser.StatOrDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#statOrDeclList}.
	 * @param ctx the parse tree
	 */
	void exitStatOrDeclList(p4_grammarParser.StatOrDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(p4_grammarParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(p4_grammarParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#switchCases}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCases(p4_grammarParser.SwitchCasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#switchCases}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCases(p4_grammarParser.SwitchCasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(p4_grammarParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(p4_grammarParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(p4_grammarParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(p4_grammarParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#statementOrDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStatementOrDeclaration(p4_grammarParser.StatementOrDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#statementOrDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStatementOrDeclaration(p4_grammarParser.StatementOrDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#tableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTableDeclaration(p4_grammarParser.TableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#tableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTableDeclaration(p4_grammarParser.TableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#tablePropertyList}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyList(p4_grammarParser.TablePropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#tablePropertyList}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyList(p4_grammarParser.TablePropertyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#tableProperty}.
	 * @param ctx the parse tree
	 */
	void enterTableProperty(p4_grammarParser.TablePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#tableProperty}.
	 * @param ctx the parse tree
	 */
	void exitTableProperty(p4_grammarParser.TablePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#keyElementList}.
	 * @param ctx the parse tree
	 */
	void enterKeyElementList(p4_grammarParser.KeyElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#keyElementList}.
	 * @param ctx the parse tree
	 */
	void exitKeyElementList(p4_grammarParser.KeyElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#keyElement}.
	 * @param ctx the parse tree
	 */
	void enterKeyElement(p4_grammarParser.KeyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#keyElement}.
	 * @param ctx the parse tree
	 */
	void exitKeyElement(p4_grammarParser.KeyElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#actionList}.
	 * @param ctx the parse tree
	 */
	void enterActionList(p4_grammarParser.ActionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#actionList}.
	 * @param ctx the parse tree
	 */
	void exitActionList(p4_grammarParser.ActionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#entriesList}.
	 * @param ctx the parse tree
	 */
	void enterEntriesList(p4_grammarParser.EntriesListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#entriesList}.
	 * @param ctx the parse tree
	 */
	void exitEntriesList(p4_grammarParser.EntriesListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(p4_grammarParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(p4_grammarParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#actionRef}.
	 * @param ctx the parse tree
	 */
	void enterActionRef(p4_grammarParser.ActionRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#actionRef}.
	 * @param ctx the parse tree
	 */
	void exitActionRef(p4_grammarParser.ActionRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#actionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterActionDeclaration(p4_grammarParser.ActionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#actionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitActionDeclaration(p4_grammarParser.ActionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(p4_grammarParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(p4_grammarParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(p4_grammarParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(p4_grammarParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#optInitializer}.
	 * @param ctx the parse tree
	 */
	void enterOptInitializer(p4_grammarParser.OptInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#optInitializer}.
	 * @param ctx the parse tree
	 */
	void exitOptInitializer(p4_grammarParser.OptInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(p4_grammarParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(p4_grammarParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(p4_grammarParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(p4_grammarParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(p4_grammarParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(p4_grammarParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#nonEmptyArgList}.
	 * @param ctx the parse tree
	 */
	void enterNonEmptyArgList(p4_grammarParser.NonEmptyArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#nonEmptyArgList}.
	 * @param ctx the parse tree
	 */
	void exitNonEmptyArgList(p4_grammarParser.NonEmptyArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(p4_grammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(p4_grammarParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(p4_grammarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(p4_grammarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#annotationBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationBody(p4_grammarParser.AnnotationBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#annotationBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationBody(p4_grammarParser.AnnotationBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#annotationToken}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationToken(p4_grammarParser.AnnotationTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#annotationToken}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationToken(p4_grammarParser.AnnotationTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(p4_grammarParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(p4_grammarParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#prefixedNonTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPrefixedNonTypeName(p4_grammarParser.PrefixedNonTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#prefixedNonTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPrefixedNonTypeName(p4_grammarParser.PrefixedNonTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(p4_grammarParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(p4_grammarParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link p4_grammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(p4_grammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link p4_grammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(p4_grammarParser.ExpressionContext ctx);
}