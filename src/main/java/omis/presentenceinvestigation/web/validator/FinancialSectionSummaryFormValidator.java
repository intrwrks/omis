package omis.presentenceinvestigation.web.validator;

import java.util.HashSet;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import omis.presentenceinvestigation.web.form.DocumentTagItem;
import omis.presentenceinvestigation.web.form.FinancialSectionSummaryDocumentAssociationItem;
import omis.presentenceinvestigation.web.form.FinancialSectionSummaryForm;
import omis.presentenceinvestigation.web.form.FinancialSectionSummaryNoteItem;
import omis.presentenceinvestigation.web.form.PresentenceInvestigationItemOperation;

/**
 * FinancialDocumentFormValidator
 * 
 *@author Trevor Isles 
 *@version 0.1.0 (July 17, 2017)
 *@since OMIS 3.0
 *
 */
public class FinancialSectionSummaryFormValidator implements Validator {
	
	private static final String TEXT_REQUIRED_MSG_KEY =
			"financialSectionSummary.text.empty";
	
	private static final String DESCRIPTION_REQUIRED_MSG_KEY =
			"description.required";
	
	private static final String DATE_REQUIRED_MSG_KEY = "date.required";
	
	private static final String TITLE_REQUIRED_MSG_KEY = "title.required";
	
	private static final String FILE_DATE_REQUIRED_MSG_KEY =
			"fileDate.required";
	
	private static final String DOCUMENT_REQUIRED_MSG_KEY = "document.required";
	
	private static final String NAME_FIELD_NAME = "name";
	
	private static final String DOCUMENT_TAG_ITEM_FIELD_NAME = 
			"financialSectionSummaryDocumentAssociationItems[%d]"
											+ ".documentTagItems[%d]";
	
	private static final String NAME_REQUIRED_MSG = "tag.name.empty";
	
	private static final String NAME_DUPLICATED_MSG = "tag.name.duplicate";
	
	/**{@inheritDoc} */
	@Override
	public boolean supports(Class<?> clazz) {
		return FinancialSectionSummaryForm.class.isAssignableFrom(clazz);
	}
	
	/**{@inheritDoc} */
	@Override
	public void validate(Object target, Errors errors) {
		
		FinancialSectionSummaryForm form =
				(FinancialSectionSummaryForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text",
				TEXT_REQUIRED_MSG_KEY);		
		
		if(form.getFinancialSectionSummaryNoteItems() != null){
			int i = 0;
			for(FinancialSectionSummaryNoteItem item :
				form.getFinancialSectionSummaryNoteItems()){
				if(PresentenceInvestigationItemOperation.UPDATE.equals(
						item.getItemOperation())
				|| PresentenceInvestigationItemOperation.CREATE.equals(
						item.getItemOperation())){
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,
						"financialSectionSummaryNoteItems["+i+"].description",
						DESCRIPTION_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
						"financialSectionSummaryNoteItems["+i+"].date",
						DATE_REQUIRED_MSG_KEY);
				}
				
				i++;
			}
		}
		
		if(form.getFinancialSectionSummaryDocumentAssociationItems() != null){
			int i = 0;
			for(FinancialSectionSummaryDocumentAssociationItem item :
					form.getFinancialSectionSummaryDocumentAssociationItems()){
				if(PresentenceInvestigationItemOperation.CREATE.equals(
						item.getItemOperation()) ||
					PresentenceInvestigationItemOperation.UPDATE.equals(
						item.getItemOperation())){
					
					ValidationUtils.rejectIfEmpty(errors,
						"financialSectionSummaryDocumentAssociationItems"
						+ "["+i+"].title",
							TITLE_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
						"financialSectionSummaryDocumentAssociationItems"
						+ "["+i+"].fileDate",
							FILE_DATE_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
							"financialSectionSummaryDocumentAssociationItems"
							+ "["+i+"].data", 
							DOCUMENT_REQUIRED_MSG_KEY);
					
					if(item.getDocumentTagItems() != null){
						List<DocumentTagItem> documentTags =
								item.getDocumentTagItems();
						HashSet<String> documentTagNames = 
								new HashSet<String>(documentTags.size());
						for (int x = 0; x < documentTags.size(); x++) {
							DocumentTagItem documentTagItem = documentTags.get(x);
							PresentenceInvestigationItemOperation
								documentTagOperation = documentTagItem
									.getItemOperation();
							if (documentTagOperation ==
									PresentenceInvestigationItemOperation.CREATE 
									|| documentTagOperation ==
									PresentenceInvestigationItemOperation.UPDATE){
								errors.pushNestedPath(String.format(
										DOCUMENT_TAG_ITEM_FIELD_NAME, i, x));
								if (documentTagNames.add(documentTagItem
										.getName())) {
									ValidationUtils.rejectIfEmpty(
											errors, NAME_FIELD_NAME, 
											NAME_REQUIRED_MSG);
								}
								else {
									errors.rejectValue(NAME_FIELD_NAME, 
											NAME_DUPLICATED_MSG);
								}
								errors.popNestedPath();
							}
						}
					}
				}
				i++;
			}
		}
	}

}
