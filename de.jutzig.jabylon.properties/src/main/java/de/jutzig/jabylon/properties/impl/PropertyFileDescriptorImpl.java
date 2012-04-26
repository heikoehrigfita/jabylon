/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.jutzig.jabylon.properties.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import de.jutzig.jabylon.properties.ProjectLocale;
import de.jutzig.jabylon.properties.PropertiesFactory;
import de.jutzig.jabylon.properties.PropertiesPackage;
import de.jutzig.jabylon.properties.PropertyFile;
import de.jutzig.jabylon.properties.PropertyFileDescriptor;
import de.jutzig.jabylon.properties.util.PropertiesResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property File Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jutzig.jabylon.properties.impl.PropertyFileDescriptorImpl#getVariant <em>Variant</em>}</li>
 *   <li>{@link de.jutzig.jabylon.properties.impl.PropertyFileDescriptorImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link de.jutzig.jabylon.properties.impl.PropertyFileDescriptorImpl#getMaster <em>Master</em>}</li>
 *   <li>{@link de.jutzig.jabylon.properties.impl.PropertyFileDescriptorImpl#getProjectLocale <em>Project Locale</em>}</li>
 *   <li>{@link de.jutzig.jabylon.properties.impl.PropertyFileDescriptorImpl#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyFileDescriptorImpl extends ResolvableImpl implements PropertyFileDescriptor {
	/**
	 * The default value of the '{@link #getVariant() <em>Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariant()
	 * @generated
	 * @ordered
	 */
	protected static final Locale VARIANT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final URI LOCATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getKeys() <em>Keys</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected static final int KEYS_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyFileDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locale getVariant() {
		return (Locale)eDynamicGet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__VARIANT, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__VARIANT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariant(Locale newVariant) {
		eDynamicSet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__VARIANT, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__VARIANT, newVariant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getLocation() {
		return (URI)eDynamicGet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__LOCATION, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__LOCATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(URI newLocation) {
		eDynamicSet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__LOCATION, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMaster() {
		return !eIsSet(PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__VARIANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyFile loadProperties() {
		URI path = absolutPath();

		PropertiesResourceImpl resource = new PropertiesResourceImpl(path);

		Map<String, Object> options = new HashMap<String, Object>();
		if(getProjectLocale()!=null && getProjectLocale().getProjectVersion()!=null &&
			getProjectLocale().getProjectVersion().getProject()!=null) {
			options.put(PropertiesResourceImpl.OPTION_FILEMODE, getProjectLocale().getProjectVersion().getProject().getPropertyType());
		}

		try {
			resource.load(options);
		} catch (FileNotFoundException e)
		{
			//The file does not exist, create a new one.
			//TODO: log this
			return PropertiesFactory.eINSTANCE.createPropertyFile();
		}
		 catch (IOException e) {
			throw new RuntimeException(e);
		}
		return (PropertyFile) resource.getContents().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void computeLocation() {
		if(isMaster())
			return;
		Locale locale = getVariant();
		URI location = getMaster().getLocation();
		String filename = location.lastSegment();
		String extension = location.fileExtension();
		if(extension!=null)
		{
			filename = filename.substring(0,filename.length()-extension.length()-1);
			filename += "_";
			filename += locale.toString();
			filename += ".";
			filename += extension;
		}
		setLocation(location.trimSegments(1).appendSegment(filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyFileDescriptor getMaster() {
		return (PropertyFileDescriptor)eDynamicGet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__MASTER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyFileDescriptor basicGetMaster() {
		return (PropertyFileDescriptor)eDynamicGet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__MASTER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaster(PropertyFileDescriptor newMaster) {
		eDynamicSet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__MASTER, newMaster);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProjectLocale getProjectLocale() {
		return (ProjectLocale)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectLocale basicGetProjectLocale() {
		return (ProjectLocale)eDynamicGet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectLocale(ProjectLocale newProjectLocale) {
		eDynamicSet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE, newProjectLocale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getKeys() {
		return (Integer)eDynamicGet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__KEYS, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__KEYS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeys(int newKeys) {
		eDynamicSet(PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__KEYS, PropertiesPackage.Literals.PROPERTY_FILE_DESCRIPTOR__KEYS, newKeys);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int internalUpdatePercentComplete() {
		if(isMaster())
			return 100;
		PropertyFileDescriptor master = getMaster();
		int keys = master.getKeys();
		int translated = getKeys();
		return (int) Math.min(100, Math.floor(((translated/(double)keys)*100)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__VARIANT:
				return getVariant();
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__LOCATION:
				return getLocation();
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER:
				if (resolve) return getMaster();
				return basicGetMaster();
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE:
				if (resolve) return getProjectLocale();
				return basicGetProjectLocale();
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__KEYS:
				return getKeys();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__VARIANT:
				setVariant((Locale)newValue);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__LOCATION:
				setLocation((URI)newValue);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER:
				setMaster((PropertyFileDescriptor)newValue);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE:
				setProjectLocale((ProjectLocale)newValue);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__KEYS:
				setKeys((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__VARIANT:
				setVariant(VARIANT_EDEFAULT);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER:
				setMaster((PropertyFileDescriptor)null);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE:
				setProjectLocale((ProjectLocale)null);
				return;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__KEYS:
				setKeys(KEYS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__VARIANT:
				return VARIANT_EDEFAULT == null ? getVariant() != null : !VARIANT_EDEFAULT.equals(getVariant());
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__LOCATION:
				return LOCATION_EDEFAULT == null ? getLocation() != null : !LOCATION_EDEFAULT.equals(getLocation());
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__MASTER:
				return basicGetMaster() != null;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__PROJECT_LOCALE:
				return basicGetProjectLocale() != null;
			case PropertiesPackage.PROPERTY_FILE_DESCRIPTOR__KEYS:
				return getKeys() != KEYS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public URI relativePath() {
		return getLocation();
	}

} //PropertyFileDescriptorImpl
