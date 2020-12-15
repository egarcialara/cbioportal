package org.cbioportal.persistence;

import org.cbioportal.model.*;
import org.cbioportal.model.util.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AlterationRepository {

    @Cacheable(cacheNames = "GeneralRepositoryCache", condition = "@cacheEnabledConfig.getEnabled()")
    // TODO write javadoc
    List<AlterationCountByGene> getSampleAlterationCounts(List<MolecularProfileCaseIdentifier> molecularProfileCaseIdentifiers,
                                                          List<Integer> entrezGeneIds,
                                                          final Select<MutationEventType> mutationEventTypes,
                                                          final Select<CopyNumberAlterationEventType> cnaEventTypes,
                                                          boolean searchFusions);

    @Cacheable(cacheNames = "GeneralRepositoryCache", condition = "@cacheEnabledConfig.getEnabled()")
    // TODO write javadoc
    List<AlterationCountByGene> getPatientAlterationCounts(List<MolecularProfileCaseIdentifier> molecularProfileCaseIdentifiers,
                                                           List<Integer> entrezGeneIds,
                                                           final Select<MutationEventType> mutationEventTypes,
                                                           final Select<CopyNumberAlterationEventType> cnaEventTypes,
                                                           boolean searchFusions);


    @Cacheable(cacheNames = "GeneralRepositoryCache", condition = "@cacheEnabledConfig.getEnabled()")
    List<CopyNumberCountByGene> getSampleCnaCounts(List<MolecularProfileCaseIdentifier> molecularProfileCaseIdentifiers,
                                                   List<Integer> entrezGeneIds,
                                                   final Select<CopyNumberAlterationEventType> cnaEventTypes);

    @Cacheable(cacheNames = "GeneralRepositoryCache", condition = "@cacheEnabledConfig.getEnabled()")
    List<CopyNumberCountByGene> getPatientCnaCounts(List<MolecularProfileCaseIdentifier> molecularProfileCaseIdentifiers,
                                                           List<Integer> entrezGeneIds,
                                                           final Select<CopyNumberAlterationEventType> cnaEventTypes);
    
}