package org.mifosplatform.organisation.dsa.handler;

import org.mifosplatform.commands.annotation.CommandType;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.organisation.dsa.service.DsaWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service 
@CommandType(entity = "DSA", action = "CREATE")
public class CreateDsaCommandHandler implements NewCommandSourceHandler {
	
	private final DsaWritePlatformService writePlatformService;
	
	@Autowired
	public CreateDsaCommandHandler(final DsaWritePlatformService writePlatformService){
		this.writePlatformService = writePlatformService;
	}
	@Transactional
	@Override
	public CommandProcessingResult processCommand(final JsonCommand command){
		return this.writePlatformService.createDsa(command);
	}

}
