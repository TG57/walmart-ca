package walmart.cqconnector.services;

import walmart.cqconnector.models.TrialModel;

import java.util.List;

public interface TrialService {
  public boolean savetoDb(TrialModel data);
//  public boolean updateDb(TrialModel data);
  public TrialModel findinDb(Integer id);
  public boolean sendBatch(List<TrialModel> data);
}
